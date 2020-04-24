package com.hotaru.utils;

import com.hotaru.core.util.CommonConstants;
import com.hotaru.core.util.GlobalHolder;
import com.hotaru.database.entities.Employee;

import javax.servlet.http.HttpSession;

public class LoggedInUserHelper {
    public static Employee getLoggedInEmployee() {
        HttpSession session = GlobalHolder.getSession();
        Object value = session.getAttribute(CommonConstants.LOGGED_IN_EMPLOYEE);
        if (value == null) {
            return null;
        } else {
            return (Employee) value;
        }
    }

    public static void setLoggedInEmployee(Employee employee) {
        GlobalHolder.getSession().setAttribute(CommonConstants.LOGGED_IN_EMPLOYEE, employee);
    }
}
