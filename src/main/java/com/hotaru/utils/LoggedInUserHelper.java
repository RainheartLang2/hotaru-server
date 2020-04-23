package com.hotaru.utils;

import com.hotaru.core.util.CommonConstants;
import com.hotaru.core.util.GlobalHolder;
import com.hotaru.database.entities.Employee;

public class LoggedInUserHelper {
    public static Employee getLoggedInEmployee() {
        return (Employee) GlobalHolder.getSession().getAttribute(CommonConstants.LOGGED_IN_EMPLOYEE);
    }

    public static void setLoggedInEmployee(Employee employee) {
        GlobalHolder.getSession().setAttribute(CommonConstants.LOGGED_IN_EMPLOYEE, employee);
    }
}
