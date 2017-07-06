package edu.efimovta.liferay.osgi.weather;

import edu.efimovta.liferay.osgi.weather.printer.service.WeatherPrinter;
import edu.efimovta.liferay.osgi.weather.printer.service.impl.FileWeatherPrinter;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

/**
 * Created by eta on 7/5/2017.
 */
public class ActivatorFileWeatherPrinter implements BundleActivator {


    private ServiceRegistration registration;

    public void start(BundleContext context) throws Exception {
        registration = context.registerService(WeatherPrinter.class.getName(), new FileWeatherPrinter(), null);
        System.out.println("###########WeatherPrinter Service Registered Successfully ##############");
    }

    public void stop(BundleContext context) throws Exception {
        registration.unregister();
        System.out.println("###########WeatherPrinter Service Unregistered##############");
    }
}
