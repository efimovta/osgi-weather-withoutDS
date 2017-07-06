package edu.efimovta.liferay.osgi.weather.service.impl;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import edu.efimovta.liferay.osgi.weather.service.WeatherGetter;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Date;

import static org.apache.http.HttpHeaders.USER_AGENT;

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
