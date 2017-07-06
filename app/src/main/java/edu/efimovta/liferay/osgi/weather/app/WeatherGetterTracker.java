package edu.efimovta.liferay.osgi.weather.app;

import edu.efimovta.liferay.osgi.weather.service.WeatherGetter;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by eta on 7/6/2017.
 */
public class WeatherGetterTracker extends ServiceTracker implements ServiceTrackerCustomizer{

    private List<WeatherGetter> weatherGetters = new ArrayList<>();

    public List<WeatherGetter> getAll() {
        List<WeatherGetter> results = new ArrayList<>(weatherGetters);
        return results;
    }

    public WeatherGetterTracker(BundleContext context) {
        super(context, WeatherGetter.class.getName(), null);
        open();
    }

    @Override
    public Object addingService(ServiceReference reference) {
        WeatherGetter weatherGetter = (WeatherGetter) context.getService(reference);

        weatherGetters.add(weatherGetter);
        System.out.println("- bind new WeatherGetter");

        return weatherGetter;
    }

    @Override
    public void removedService(ServiceReference reference, Object service) {
        weatherGetters.remove(service);
        System.out.println("- unbind WeatherGetter");

        super.removedService(reference, service);
    }
}