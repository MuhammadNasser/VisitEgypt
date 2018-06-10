package com.visit_egypt.visitegypt.server;

import java.util.ArrayList;
import java.util.Locale;

public class Constants {

    private static final String apiUrl = "https://www.aqarcircle.com/api/";
    private static final String imageSmallUrl = "https://www.aqarcircle.com/Uploads/Property/Small/Ready/";


    public static String getApiUrl() {
        return apiUrl;
    }

    public static String getImageSmallUrl() {
        return imageSmallUrl;
    }

    public static String getLanguageIndex() {
        if (Constants.isArabic()) {
            return "1";
        } else if (Constants.isEnglish()) {
            return "2";
        } else if (Constants.isFrench()) {
            return "3";
        } else {
            return "4";
        }
    }

    public static boolean isArabic() {
        return Locale.getDefault().getISO3Language().toLowerCase().contains("ar");
    }

    public static boolean isEnglish() {
        return Locale.getDefault().getISO3Language().toLowerCase().contains("en");
    }

    public static boolean isRussian() {
        return Locale.getDefault().getISO3Language().toLowerCase().contains("ru");
    }

    public static boolean isFrench() {
        return Locale.getDefault().getISO3Language().toLowerCase().contains("fr");
    }


}
