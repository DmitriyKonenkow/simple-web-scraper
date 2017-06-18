package ru.spb.konenkow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Hello world!
 */
public class App {

    private static final Logger LOG = LoggerFactory.getLogger(App.class);
    private static final Properties properties;

    public static Properties getProperties() {
        return properties;
    }


    static {
        properties = new Properties();
        try (FileReader fileReader = new FileReader("scraper.conf")) {
            properties.load(fileReader);
        } catch (IOException e) {
            LOG.error("Config not found.", e);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
