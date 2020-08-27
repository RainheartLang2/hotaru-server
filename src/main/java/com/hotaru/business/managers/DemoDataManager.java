package com.hotaru.business.managers;

import com.hotaru.core.exceptions.ValidationException;
import com.hotaru.database.entities.Employee;
import com.hotaru.database.entities.Login;

public class DemoDataManager {
    private static DemoDataManager INSTANCE = new DemoDataManager();

    private Employee adminUser;

    public static DemoDataManager getInstance() {
        return INSTANCE;
    }

    private DemoDataManager() {}

    public void loadDemoData() throws ValidationException {
        this.adminUser = new Employee();
        Login adminLogin = new Login("admin", "manager");

        EmployeeManager employeeManager = EmployeeManager.getInstance();
        employeeManager.addEmployee(adminUser, adminLogin);
    }
}
