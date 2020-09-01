package com.hotaru.core.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.googlecode.jsonrpc4j.JsonRpcMultiServer;
import com.hotaru.rpc.locality.UserLocalityService;
import com.hotaru.rpc.login.LoginService;
import com.hotaru.rpc.order.UserOrderService;
import com.hotaru.rpc.region.UserRegionService;
import com.hotaru.rpc.setting.UserSettingService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class PreloginZoneServlet extends HttpServlet {
    private JsonRpcMultiServer jsonRpcServer;

    protected void registerService(JsonRpcMultiServer service, Class cl) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        service.addService(cl.getSimpleName(), cl.getDeclaredConstructor().newInstance(), cl);
    }

    public void init(ServletConfig config) throws ServletException {
        this.jsonRpcServer = new JsonRpcMultiServer(new ObjectMapper());

        try {
            this.registerService(jsonRpcServer, LoginService.class);
            jsonRpcServer.addService("OrderService", new UserOrderService(), UserOrderService.class);
            jsonRpcServer.addService("SettingsService", new UserSettingService(), UserSettingService.class);
            jsonRpcServer.addService("RegionService", new UserRegionService(), UserRegionService.class);
            jsonRpcServer.addService("LocalityService", new UserLocalityService(), UserLocalityService.class);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.jsonRpcServer.handle(req, resp);
    }
}
