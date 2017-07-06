package edu.efimovta.liferay.osgi.weather.service.impl;

import edu.efimovta.liferay.osgi.weather.service.WeatherGetter;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

/**
 * Created by eta on 7/5/2017.
 */
public class ActivatorApixuWeatherGetter implements BundleActivator {
    private ServiceRegistration registration;

    @Override
    public void start(BundleContext context) throws Exception {
        registration = context.registerService(WeatherGetter.class.getName(), new ApixuWeatherGetter(), null);
        System.out.println("###########ApixuWeatherGetter Service Registered Successfully ##############");
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        registration.unregister();
        System.out.println("###########ApixuWeatherGetter Service Unregistered##############");
    }
}
