package ua.training.controller;

import java.util.ResourceBundle;

/**
 * Configuration manager to obtain configuration properties
 * @author Pavel Denisenko
 * @since 05.03.2019
 */
public class ConfigManager {

    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("config");

    public static String getProperty(String key) {
        return BUNDLE.getString(key);
    }

}
