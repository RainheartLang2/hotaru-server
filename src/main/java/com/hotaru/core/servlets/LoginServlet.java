package com.hotaru.core.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.googlecode.jsonrpc4j.JsonRpcMultiServer;
import com.hotaru.rpc.EmployeeService;
import com.hotaru.rpc.EmployeeServiceBase;
import com.hotaru.rpc.login.LoginService;
import com.hotaru.rpc.login.LoginServiceBase;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private JsonRpcMultiServer jsonRpcServer;

    public void init(ServletConfig config) {
        this.jsonRpcServer = new JsonRpcMultiServer(new ObjectMapper());
        jsonRpcServer.addService("LoginService", new LoginService(), LoginServiceBase.class);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.jsonRpcServer.handle(req, resp);
    }
}
