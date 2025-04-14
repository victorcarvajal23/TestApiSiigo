package com.siigo.automation.utils;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.util.Properties;

public class GetProperties {

    private static final Logger LOGGER = LoggerFactory.getLogger(GetProperties.class);
    private static final String PATH = "./properties";

    public static String of(String property) {
        Properties properties;
        properties = new Properties();
        try {
            properties.load(new FileReader(PATH));
        } catch (Exception e) {
            LOGGER.info(String.valueOf(e));
        }
        return properties.getProperty(property);
    }
}
