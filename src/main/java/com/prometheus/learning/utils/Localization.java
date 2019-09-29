package com.prometheus.learning.utils;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Localization {

    public void localization() {

        /**
         * A Locale object is a representation of specific geographical, political, or cultural region.
         * Locale may contain information about language, region, variant, script, extension.
         */

        Locale frLocale = new Locale.Builder().setLanguage(Locale.FRANCE.getLanguage()).setRegion("CA").build();

        Locale enLocale = new Locale("en");
        Locale enLocale2 = new Locale("en", "US");
        Locale enLocale3 = Locale.forLanguageTag("en-US");

        Locale zhLocale = Locale.CHINESE; //langugae
        Locale itLocale = Locale.ITALY; //country

        /** Default Locale is taken by JVP as the Locale of local platform */

        Locale defaultLocale = Locale.getDefault();

        Locale.setDefault(Locale.US);

    }

    public void resources() {

        /**
         * Properties file contain key-value pairs separated by =, : or space, though = is used most often.
         * Properties file has extension .properties
         */

        /** ResourceBundle class contains a static method getBundle(), which reads a properties file
         *  with the specified base name and default locale
         */

        ResourceBundle resourceBundle = ResourceBundle.getBundle("dev");
        Enumeration<String> enumeration = resourceBundle.getKeys();
        Set<String> keySet = resourceBundle.keySet();

        while(enumeration.hasMoreElements()) {
            String key = enumeration.nextElement();
            System.out.println(resourceBundle.getString(key));
        }

        /**
         * ResourceBundle has 2 direct descendants:
         * PropertyResourceBundle - managing static strings from properties file
         * ListResourceBundle - handling objects from Java classes
         */

        PropertyResourceBundle bundle1 = (PropertyResourceBundle)(ResourceBundle.getBundle("dev"));
        try {
            PropertyResourceBundle bundle2 = new PropertyResourceBundle(new FileInputStream("dev.properties"));
            PropertyResourceBundle bundle3 = new PropertyResourceBundle(new FileReader("dev.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }




    }

}
