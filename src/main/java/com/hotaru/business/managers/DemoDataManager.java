package com.hotaru.business.managers;

import com.hotaru.core.exceptions.ValidationException;
import com.hotaru.database.entities.Employee;
import com.hotaru.database.entities.Login;
import com.hotaru.database.entities.SettingsRecord;
import com.hotaru.database.resources.SettingsResource;

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

        SettingsResource settingsResource = SettingsResource.getInstance();

        settingsResource.setSetting(SettingsRecord.UNIT_PRICE_KEY, "60");
        settingsResource.setSetting(SettingsRecord.DELIVERY_PRICE_KEY, "20");
        settingsResource.setSetting(SettingsRecord.MINIMAL_DELIVERY_AMOUNT, "60");
        settingsResource.setSetting(SettingsRecord.MINIMAL_DELIVERY_COST, "500");
    }
}
