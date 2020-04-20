package com.hotaru.rest.services.login;

import com.hotaru.database.entities.Employee;
import com.hotaru.database.entities.Login;
import com.hotaru.database.resources.EmployeeResource;
import com.hotaru.database.resources.LoginResource;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

@Path("/login")
@Produces("application/json; charset=UTF-8")
@Consumes("application/json; charset=UTF-8")
public class LoginService {

    @POST
    @Path("/")
    public Response login(Login login, @Context HttpServletRequest request) {
        Login loginFromBase = LoginResource.getInstance().getByLoginName(login.getLoginName());
        if (loginFromBase != null && loginFromBase.getPassword().equals(login.getPassword())) {
            Employee employee = EmployeeResource.getInstance().getById(loginFromBase.getUserId());
            request.getSession().setAttribute("loggedInUser", employee);
            return Response.ok().cookie(new NewCookie("JSESSIONID", "1")).build();
        } else {
            return Response.ok().build();
        }
    }
}
