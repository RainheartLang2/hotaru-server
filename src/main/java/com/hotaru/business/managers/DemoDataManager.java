package com.hotaru.business.managers;

import com.hotaru.business.logic.Settings;
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

        SettingsManager settingsManager = SettingsManager.getInstance();
        settingsManager.setIntegerSetting(Settings.UNIT_PRICE, 60);
        settingsManager.setIntegerSetting(Settings.DELIVERY_PRICE, 20);
        settingsManager.setIntegerSetting(Settings.MINIMAL_DELIVERY_AMOUNT, 60);
        settingsManager.setIntegerSetting(Settings.MINIMAL_DELIVERY_COST, 500);
    }
}
