package edu.efimovta.liferay.osgi.weather.app;


import edu.efimovta.liferay.osgi.weather.dto.Weather;
import edu.efimovta.liferay.osgi.weather.dto.impl.WeatherImpl;
import edu.efimovta.liferay.osgi.weather.printer.service.WeatherPrinter;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

/**
 * Created by eta on 7/5/2017.
 */
public class ActivatorApp implements BundleActivator {

    public void start(BundleContext context) throws Exception {
        System.out.println("ActivatorApp start(); 1");
//        ServiceReference ref = context.getServiceReference(WeatherGetter.class.getName());
        ServiceReference ref2 = context.getServiceReference(WeatherPrinter.class.getName());
//        WeatherGetter weatherGetter;
        WeatherPrinter weatherPrinter;
//        if (ref != null)
//        {
//             weatherGetter = (WeatherGetter) context.getService(ref);
//        }
//        else
//        {
//            System.err.println("Couldn't find WeatherGetter...");
//            return;
//        }
        if (ref2 != null)
        {
            weatherPrinter = (WeatherPrinter) context.getService(ref2);
        }
        else
        {
            System.err.println("Couldn't find WeatherPrinter...");
            return;
        }

//        Weather weather =  weatherGetter.get();
        Weather weather = new WeatherImpl("my source");
        System.out.println("################## ActivatorApp start(); process");
        System.out.println(weather.getSource());
        System.out.println(weather.getSource());
        System.out.println(weather.getSource());
        System.out.println(weather.getSource());
        weatherPrinter.print(weather);

//        context.ungetService(ref);
        context.ungetService(ref2);
        System.out.println("ActivatorApp start(); 2");
    }

    public void stop(BundleContext bundleContext) throws Exception {

    }
}
