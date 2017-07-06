package edu.efimovta.liferay.osgi.weather.printer.service;

import edu.efimovta.liferay.osgi.weather.dto.Weather;

/**
 * Created by eta on 7/5/2017.
 */
public interface WeatherPrinter {
    void print(Weather weather) throws WeatherPrinterException;
}
