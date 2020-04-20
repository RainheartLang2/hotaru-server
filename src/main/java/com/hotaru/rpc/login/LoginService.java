package com.hotaru.rpc.login;

import com.hotaru.core.util.GlobalHolder;
import com.hotaru.database.entities.Employee;
import com.hotaru.database.entities.Login;
import com.hotaru.database.resources.EmployeeResource;
import com.hotaru.database.resources.LoginResource;

public class LoginService implements LoginServiceBase {

    @Override
    public void login(String login, String password) {
        Login loginFromBase = LoginResource.getInstance().getByLoginName(login);
        if (loginFromBase != null && loginFromBase.getPassword().equals(password)) {
            Employee employee = EmployeeResource.getInstance().getById(loginFromBase.getUserId());
            GlobalHolder.getSession().setAttribute("loggedInUser", employee);
        }
    }
}
