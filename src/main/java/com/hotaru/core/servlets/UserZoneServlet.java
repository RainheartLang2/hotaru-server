package com.hotaru.core.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.googlecode.jsonrpc4j.JsonRpcMultiServer;
import com.hotaru.business.logic.Settings;
import com.hotaru.business.managers.DemoDataManager;
import com.hotaru.business.managers.SettingsManager;
import com.hotaru.core.database.SessionFactoryHolder;
import com.hotaru.core.exceptions.ValidationException;
import com.hotaru.rpc.EmployeeService;
import com.hotaru.rpc.order.AdminOrderService;
import com.hotaru.rpc.profile.UserProfileService;
import org.hibernate.Session;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class UserZoneServlet extends HttpServlet {
    private JsonRpcMultiServer jsonRpcServer;

    private void loadDemoData() throws ValidationException, IOException {
        Session session = SessionFactoryHolder.getSession();
        session.beginTransaction();
        try {
            SettingsManager settingsManager = SettingsManager.getInstance();
            boolean demoDataLoaded = settingsManager.getBooleanSetting(Settings.DEMO_DATA_LOADED);
            if (!demoDataLoaded) {
                DemoDataManager.getInstance().loadDemoData();
                settingsManager.setBooleanSetting(Settings.DEMO_DATA_LOADED, true);
            }
        } finally {
            session.getTransaction().commit();
        }
    }

    protected void registerService(JsonRpcMultiServer service, Class cl) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        service.addService(cl.getSimpleName(), cl.getDeclaredConstructor().newInstance(), cl);
    }

    public void init(ServletConfig config) throws ServletException {
        try {
            loadDemoData();
        } catch (ValidationException | IOException e) {
            e.printStackTrace();
        }

        this.jsonRpcServer = new JsonRpcMultiServer(new ObjectMapper());

        try {
            registerService(jsonRpcServer, EmployeeService.class);
            registerService(jsonRpcServer, UserProfileService.class);
            jsonRpcServer.addService("OrderService", new AdminOrderService(), AdminOrderService.class);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.jsonRpcServer.handle(req, resp);
    }
}
