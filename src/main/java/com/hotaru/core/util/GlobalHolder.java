package com.hotaru.core.util;

import javax.servlet.ServletRequest;

public class GlobalHolder {
    private static String LOCATION;

    public static String getLocation() {
        return LOCATION;
    }

    public static void initialize(ServletRequest request) {
        LOCATION = request.getScheme()
                + "://" + request.getServerName()
                + ":" + request.getServerPort() + "/";
    }
}
