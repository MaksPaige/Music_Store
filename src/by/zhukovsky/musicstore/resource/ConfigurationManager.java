package by.zhukovsky.musicstore.resource;

import java.util.ResourceBundle;

/**
 * Created by Maksim Zhukovsky on 24.03.2018.
 */

public class ConfigurationManager {

    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.config");

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }

}
