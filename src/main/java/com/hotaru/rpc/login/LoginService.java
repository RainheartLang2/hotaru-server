package com.hotaru.rpc.login;

import com.hotaru.business.logic.Settings;
import com.hotaru.business.managers.SettingsManager;
import com.hotaru.core.exceptions.IncorrectCredentialsException;
import com.hotaru.database.entities.Employee;
import com.hotaru.database.entities.Login;
import com.hotaru.database.resources.EmployeeResource;
import com.hotaru.database.resources.LoginResource;
import com.hotaru.utils.LoggedInUserHelper;

public class LoginService implements LoginServiceBase {

    @Override
    public String login(String login, String password) throws IncorrectCredentialsException {
        Login loginFromBase = LoginResource.getInstance().getByLoginName(login);
        if (loginFromBase != null && loginFromBase.getPassword().equals(password)) {
            Employee employee = EmployeeResource.getInstance().getById(loginFromBase.getUserId());
            LoggedInUserHelper.setLoggedInEmployee(employee);
            return SettingsManager.getInstance().getStringSetting(Settings.ADMIN_APP_REDIRECT);
        } else {
            throw new IncorrectCredentialsException();
        }
    }

    @Override
    public void logout() {
        LoggedInUserHelper.setLoggedInEmployee(null);
    }
}
