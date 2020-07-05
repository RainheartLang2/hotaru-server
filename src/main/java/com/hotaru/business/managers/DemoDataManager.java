package com.hotaru.business.managers;

import com.hotaru.core.exceptions.ValidationException;
import com.hotaru.database.entities.*;

public class DemoDataManager {
    private static DemoDataManager INSTANCE = new DemoDataManager();

    public static DemoDataManager getInstance() {
        return INSTANCE;
    }

    private DemoDataManager() {}

    public void loadDemoData() throws ValidationException {
        ClinicManager clinicManager = ClinicManager.getInstance();
        Clinic clinic = new Clinic("Первая клиника",
                null,
                "1234567890",
                "test@test.com",
                "http://localhost:3000/",
                "Город",
                "Адрес",
                false,
                true,
                null);
        clinicManager.addClinic(clinic);

        Employee adminUser = new Employee("Иван", "Иванович", "Иванов",
                false,
                true,
                "1112223344",
                "Ivanov@clinic.com",
                "Ул. Ивановская, 1",
                null,
                null);
        Login adminLogin = new Login("admin", "manager");

        Employee additionalUser = new Employee("Пётр", "Петрович", "Петров",
                false,
                true,
                "1113334455",
                "Petrov@clinic.com",
                "Ул. Петровская, 2",
                clinic.getId(),
                null);
        Login additionalUserLogin = new Login("petrov", "petrov");

        EmployeeManager employeeManager = EmployeeManager.getInstance();
        employeeManager.addEmployee(adminUser, adminLogin);
        employeeManager.addEmployee(additionalUser, additionalUserLogin);

        Species cats = new Species("Кошки");
        Species dogs = new Species("Собаки");
        SpeciesManager speciesManager = SpeciesManager.getInstance();
        speciesManager.addSpecies(cats);
        speciesManager.addSpecies(dogs);


        Breed persian = new Breed("Персидский", cats.getId());
        Breed siamese = new Breed("Сиамский", cats.getId());
        Breed shepard = new Breed("Овчарка", dogs.getId());
        Breed corgi = new Breed("Корги", dogs.getId());

        BreedManager breedManager = BreedManager.getInstance();
        breedManager.addBreed(persian);
        breedManager.addBreed(siamese);
        breedManager.addBreed(shepard);
        breedManager.addBreed(corgi);

        Client client = new Client("Павел", "Павлович", "Павлов",
                                    "9998887766",
                                    "ул. Павловская",
                                    "pavlov@pav.lov");

        ClientManager clientManager = ClientManager.getInstance();
        clientManager.addClient(client);
    }
}
