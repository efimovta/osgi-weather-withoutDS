package edu.efimovta.liferay.osgi.weather.printer.service.impl;

import edu.efimovta.liferay.osgi.weather.dto.Weather;
import edu.efimovta.liferay.osgi.weather.printer.service.WeatherPrinter;
import edu.efimovta.liferay.osgi.weather.printer.service.WeatherPrinterException;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by eta on 7/5/2017.
 */

public class FileWeatherPrinter implements WeatherPrinter {
    private final String path = "..//..//testFile2.txt";

    public void print(Weather weather) throws WeatherPrinterException {

        System.out.println("################## ActivatorApp start(); process 2");
//        Weather w = new Weather("ogo1");
        System.out.println(weather.getSource());
        System.out.println(weather.getSource());
        System.out.println(weather.getSource());
        System.out.println(weather.getSource());
        try {
            FileOutputStream out = new FileOutputStream(path);

            StringBuilder sb = new StringBuilder();

            sb.append("~~~~~~~~~~# " + weather.getSource() + " #~~~~~~~~~~");
            sb.append("\nCity: ").append(weather.getCity());
            sb.append("\ncountry: ").append(weather.getCountry());
            sb.append("\nlat, lon: ").append(weather.getLat()).append(", ").append(weather.getLon());
            sb.append("\nconditionText: ").append(weather.getCondition());
            sb.append("\navgtemp_c: ").append(weather.getAvgTemp());
            sb.append("\nmintemp_c: ").append(weather.getMinTemp());
            sb.append("\nmaxtemp_c: ").append(weather.getMaxTemp());
            sb.append("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            out.write(sb.toString().getBytes());
            out.close();
        } catch (IOException e) {
            throw new WeatherPrinterException(e);
        }
    }
}
