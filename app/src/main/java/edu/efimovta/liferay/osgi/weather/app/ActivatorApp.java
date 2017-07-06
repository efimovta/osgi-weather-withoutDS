package edu.efimovta.liferay.osgi.weather.app;


import edu.efimovta.liferay.osgi.weather.dto.Weather;
import edu.efimovta.liferay.osgi.weather.printer.service.WeatherPrinter;
import edu.efimovta.liferay.osgi.weather.service.WeatherGetter;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eta on 7/5/2017.
 */
public class ActivatorApp implements BundleActivator {
    WeatherGetterTracker tracker;

    public void start(BundleContext context) throws Exception {
        System.out.println("ActivatorApp start(); 1");
        tracker = new WeatherGetterTracker(context);

        ServiceReference ref = context.getServiceReference(WeatherPrinter.class.getName());
        WeatherPrinter weatherPrinter;
        if (ref != null) {
            weatherPrinter = (WeatherPrinter) context.getService(ref);
        } else {
            System.err.println("Couldn't find WeatherPrinter...");
            tracker.close();
            return;
        }
        List<WeatherGetter> weatherGetters = tracker.getAll();
        if (weatherGetters.size() == 0) {
            System.err.println("Couldn't find WeatherGetter...");
            tracker.close();
            return;
        }

        List<Weather> weathers = new ArrayList<>();
        for (WeatherGetter weatherGetter : weatherGetters) {
            Weather weather = weatherGetter.get();
            weathers.add(weather);
        }
        weatherPrinter.print(weathers);

        context.ungetService(ref);
        tracker.close();

        System.out.println("ActivatorApp start(); 2");
    }

    public void stop(BundleContext bundleContext) throws Exception {
    }
}
