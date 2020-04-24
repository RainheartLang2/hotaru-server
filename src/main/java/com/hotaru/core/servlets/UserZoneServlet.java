package com.hotaru.core.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.googlecode.jsonrpc4j.JsonRpcMultiServer;
import com.hotaru.rpc.EmployeeService;
import com.hotaru.rpc.clinic.ClinicService;
import com.hotaru.rpc.profile.UserProfileService;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserZoneServlet extends HttpServlet {
    private JsonRpcMultiServer jsonRpcServer;

    public void init(ServletConfig config) {
        this.jsonRpcServer = new JsonRpcMultiServer(new ObjectMapper());
        jsonRpcServer.addService("EmployeeService", new EmployeeService(), EmployeeService.class);
        jsonRpcServer.addService("UserProfileService", new UserProfileService(), UserProfileService.class);
        jsonRpcServer.addService("ClinicService", new ClinicService(), ClinicService.class);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.jsonRpcServer.handle(req, resp);
    }
}
