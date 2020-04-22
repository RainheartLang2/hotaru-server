package com.hotaru.rpc.login;

import com.hotaru.core.exceptions.IncorrectCredentialsException;
import com.hotaru.core.util.CommonConstants;
import com.hotaru.core.util.GlobalHolder;
import com.hotaru.database.entities.Employee;
import com.hotaru.database.entities.Login;
import com.hotaru.database.resources.EmployeeResource;
import com.hotaru.database.resources.LoginResource;

public class LoginService implements LoginServiceBase {

    private static final String APPLICATION_REDIRECT = "http://localhost:3000/admin";
    @Override
    public String login(String login, String password) throws IncorrectCredentialsException {
        Login loginFromBase = LoginResource.getInstance().getByLoginName(login);
        if (loginFromBase != null && loginFromBase.getPassword().equals(password)) {
            Employee employee = EmployeeResource.getInstance().getById(loginFromBase.getUserId());
            GlobalHolder.getSession().setAttribute(CommonConstants.LOGGED_IN_USER_ATTRIBUTE, employee);
            return APPLICATION_REDIRECT;
        } else {
            throw new IncorrectCredentialsException();
        }
    }
}
