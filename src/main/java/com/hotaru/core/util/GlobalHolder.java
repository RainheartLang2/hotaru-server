package com.hotaru.core.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GlobalHolder {
    private static ThreadLocal<String> LOCATION = new ThreadLocal<>();
    private static ThreadLocal<HttpSession> SESSION = new ThreadLocal<>();

    public static String getLocation() {
        return LOCATION.get();
    }
    public static HttpSession getSession() {
        return SESSION.get();
    }

    public static void initialize(HttpServletRequest request) {
        LOCATION.set(request.getScheme()
                + "://" + request.getServerName()
                + ":" + request.getServerPort() + "/");
        SESSION.set(request.getSession());
    }
}
