package com.hotaru.core.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GlobalHolder {
    private static ThreadLocal<String> LOCATION = new ThreadLocal<>();
    private static ThreadLocal<HttpSession> SESSION = new ThreadLocal<>();
    private static ThreadLocal<HttpServletRequest> REQUEST = new ThreadLocal<>();
    private static ThreadLocal<HttpServletResponse> RESPONSE = new ThreadLocal<>();

    public static String getLocation() {
        return LOCATION.get();
    }
    public static HttpSession getSession() {
        return SESSION.get();
    }
    public static HttpServletRequest getRequest() {
        return REQUEST.get();
    }
    public static HttpServletResponse getResponse() {
        return RESPONSE.get();
    }

    public static void initialize(HttpServletRequest request, HttpServletResponse response) {
        LOCATION.set(request.getScheme()
                + "://" + request.getServerName()
                + ":" + request.getServerPort() + "/");
        SESSION.set(request.getSession());
        REQUEST.set(request);
        RESPONSE.set(response);
    }
}
