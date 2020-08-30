package com.hotaru.business.managers;

import com.hotaru.business.logic.Settings;
import com.hotaru.business.logic.objects.Price;
import com.hotaru.core.exceptions.ValidationException;
import com.hotaru.database.entities.Employee;
import com.hotaru.database.entities.Login;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemoDataManager {
    private static DemoDataManager INSTANCE = new DemoDataManager();

    private Employee adminUser;

    public static DemoDataManager getInstance() {
        return INSTANCE;
    }

    private DemoDataManager() {}

    public void loadDemoData() throws ValidationException, IOException {
        this.adminUser = new Employee();
        Login adminLogin = new Login("admin", "manager");

        EmployeeManager employeeManager = EmployeeManager.getInstance();
        employeeManager.addEmployee(adminUser, adminLogin);

        SettingsManager settingsManager = SettingsManager.getInstance();
        settingsManager.setIntegerSetting(Settings.UNIT_PRICE, 220);

        List<Price> closeDeliveryPrices = new ArrayList<>(Arrays.asList(
                new Price(0, 10, 400),
                new Price(10, 30, 250),
                new Price(30, null, 0)
        ));

        List<Price> distantDeliveryPrices = new ArrayList<>(Arrays.asList(
                new Price(0, 20, 20),
                new Price(20, 100, 15),
                new Price(100, null, 10)
        ));
        settingsManager.setPriceSettings(Settings.LOCAL_DELIVERY_PRICES, closeDeliveryPrices);
        settingsManager.setPriceSettings(Settings.REGION_DELIVERY_PRICES, distantDeliveryPrices);
    }
}
