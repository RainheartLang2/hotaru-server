package com.hotaru.business.managers;

import com.hotaru.business.logic.enums.PersonType;
import com.hotaru.business.logic.enums.SalesType;
import com.hotaru.business.logic.enums.StockType;
import com.hotaru.core.exceptions.ValidationException;
import com.hotaru.database.entities.*;
import com.hotaru.database.resources.*;

public class DemoDataManager {
    private static DemoDataManager INSTANCE = new DemoDataManager();

    private Employee adminUser;
    private Employee clinicUser;
    private Clinic firstClinic;

    public static DemoDataManager getInstance() {
        return INSTANCE;
    }

    private DemoDataManager() {}

    private void loadVisitResult() {
        VisitResultResource resource = VisitResultResource.getInstance();
        resource.saveOrUpdate(new VisitResult("Повторный приём"));
        resource.saveOrUpdate(new VisitResult("Частичное выздоровление"));
        resource.saveOrUpdate(new VisitResult("Полное выздоровление"));
        resource.saveOrUpdate(new VisitResult("Первичный приём"));
        resource.saveOrUpdate(new VisitResult("Летальный исход"));
    }

    private void loadAnimalColors() {
        AnimalColorResource resource = AnimalColorResource.getInstance();
        resource.saveOrUpdate(new AnimalColor("колор-поинт"));
        resource.saveOrUpdate(new AnimalColor("палевый"));
        resource.saveOrUpdate(new AnimalColor("голубой черепаховый"));
        resource.saveOrUpdate(new AnimalColor("черепаховый"));
        resource.saveOrUpdate(new AnimalColor("лиловый"));
        resource.saveOrUpdate(new AnimalColor("разнообразный"));
        resource.saveOrUpdate(new AnimalColor("тигровый"));
        resource.saveOrUpdate(new AnimalColor("серебристый"));
        resource.saveOrUpdate(new AnimalColor("персиковый"));
        resource.saveOrUpdate(new AnimalColor("черноподпалый"));
        resource.saveOrUpdate(new AnimalColor("коричневый"));
        resource.saveOrUpdate(new AnimalColor("рыжий"));
        resource.saveOrUpdate(new AnimalColor("голубой"));
        resource.saveOrUpdate(new AnimalColor("чёрный"));
        resource.saveOrUpdate(new AnimalColor("серый"));
        resource.saveOrUpdate(new AnimalColor("белый"));
    }

    private void loadGoodsProducers() {
        GoodsProducerResource resource = GoodsProducerResource.getInstance();
        resource.saveOrUpdate(new GoodsProducer("ПроМедЭксперт100500"));
        resource.saveOrUpdate(new GoodsProducer("Aibolit Enterprise"));
        resource.saveOrUpdate(new GoodsProducer("Dr. Dulittle Association"));
    }

    private void loadVisitPurposes() {
        VisitPurposeResource resource = VisitPurposeResource.getInstance();
        resource.saveOrUpdate(new VisitPurpose("Вакцинация"));
        resource.saveOrUpdate(new VisitPurpose("Вторичный"));
        resource.saveOrUpdate(new VisitPurpose("Грумминг"));
        resource.saveOrUpdate(new VisitPurpose("Первичный"));
        resource.saveOrUpdate(new VisitPurpose("Рентген"));
        resource.saveOrUpdate(new VisitPurpose("Реферальный"));
        resource.saveOrUpdate(new VisitPurpose("Сканирование документа"));
        resource.saveOrUpdate(new VisitPurpose("Стационар"));
        resource.saveOrUpdate(new VisitPurpose("Хирургия"));
        resource.saveOrUpdate(new VisitPurpose("Экстренный"));
    }

    private void loadDiagnosis() {
        DiagnosisResource resource = DiagnosisResource.getInstance();
        resource.saveOrUpdate(new Diagnosis("Анемия"));
        resource.saveOrUpdate(new Diagnosis("Анорексия"));
        resource.saveOrUpdate(new Diagnosis("Анорексия, кахесия"));
        resource.saveOrUpdate(new Diagnosis("Артрозы, операции на суставах"));
        resource.saveOrUpdate(new Diagnosis("Асцит при болезнях печени"));
        resource.saveOrUpdate(new Diagnosis("Асцит при нехватке белка"));
        resource.saveOrUpdate(new Diagnosis("Асцит при почечной недостаточности"));
        resource.saveOrUpdate(new Diagnosis("Асцит при сердечной недостаточности"));
        resource.saveOrUpdate(new Diagnosis("Атопия"));
        resource.saveOrUpdate(new Diagnosis("Воспаление кишечника хроническое"));
        resource.saveOrUpdate(new Diagnosis("Восстановительный период после болезни"));
        resource.saveOrUpdate(new Diagnosis("Гастрит хронический"));
        resource.saveOrUpdate(new Diagnosis("Гастроэнтерит"));
        resource.saveOrUpdate(new Diagnosis("Гепатит"));
        resource.saveOrUpdate(new Diagnosis("Гепатит при энцефалопатии"));
        resource.saveOrUpdate(new Diagnosis("Гигиена ротовой полости"));
        resource.saveOrUpdate(new Diagnosis("Гипергликемия"));
        resource.saveOrUpdate(new Diagnosis("Гиперлипидемия"));
        resource.saveOrUpdate(new Diagnosis("Гипертиреоидизм"));
        resource.saveOrUpdate(new Diagnosis("Гипертония"));
        resource.saveOrUpdate(new Diagnosis("Дерматит"));
        resource.saveOrUpdate(new Diagnosis("Дерматит (от укусов насекомых, пиодерматит)"));
        resource.saveOrUpdate(new Diagnosis("Дерматит, вызванный стрессом"));
        resource.saveOrUpdate(new Diagnosis("Диарея"));
    }

    private void loadAnimals() {
        SpeciesManager speciesManager = SpeciesManager.getInstance();

        Species dogs = new Species("Собаки");
        Species cats = new Species("Кошки");
        Species rats = new Species("Крысы");
        Species hedgehogs = new Species("Ежи");
        Species hamsters = new Species("Хомяки");
        Species guineaPigs = new Species("Морские свинки");
        Species horses = new Species("Лошади");
        Species goats = new Species("Козы");
        Species cows = new Species("Коровы");
        Species parrots = new Species("Попугаи");


        speciesManager.addSpecies(dogs);
        speciesManager.addSpecies(cats);
        speciesManager.addSpecies(rats);
        speciesManager.addSpecies(hedgehogs);
        speciesManager.addSpecies(hamsters);
        speciesManager.addSpecies(guineaPigs);
        speciesManager.addSpecies(horses);
        speciesManager.addSpecies(goats);
        speciesManager.addSpecies(cows);


        BreedManager breedManager = BreedManager.getInstance();

        Breed normalHedgehog = new Breed("Ёж обыкновенный", hedgehogs.getId());
        Breed earyHedgehog = new Breed("Ёж ушастый", hedgehogs.getId());

        breedManager.addBreed(normalHedgehog);
        breedManager.addBreed(earyHedgehog);

        breedManager.addBreed(new Breed("Американский бобтейл", cats.getId()));
        breedManager.addBreed(new Breed("Ангорская", cats.getId()));
        breedManager.addBreed(new Breed("Беспородная", cats.getId()));
        breedManager.addBreed(new Breed("Британская", cats.getId()));
        breedManager.addBreed(new Breed("Манчкин", cats.getId()));
        breedManager.addBreed(new Breed("Мейнкун", cats.getId()));
        breedManager.addBreed(new Breed("Рэгдолл", cats.getId()));
        breedManager.addBreed(new Breed("Персидская", cats.getId()));
        breedManager.addBreed(new Breed("Сиамская", cats.getId()));
        breedManager.addBreed(new Breed("Сфинкс", cats.getId()));
        breedManager.addBreed(new Breed("Шотландская", cats.getId()));
        breedManager.addBreed(new Breed("Волнистый попугай", parrots.getId()));
        breedManager.addBreed(new Breed("Попугай ара", parrots.getId()));

        breedManager.addBreed(new Breed("Немецкий шпиц", dogs.getId()));
        breedManager.addBreed(new Breed("Английский спаниэль", dogs.getId()));
        breedManager.addBreed(new Breed("Беспородная", dogs.getId()));
        breedManager.addBreed(new Breed("Бассет-хаунд", dogs.getId()));
        breedManager.addBreed(new Breed("Боксёр", dogs.getId()));
        breedManager.addBreed(new Breed("Гончая", dogs.getId()));
        breedManager.addBreed(new Breed("Далматин", dogs.getId()));
        breedManager.addBreed(new Breed("Дог", dogs.getId()));
        breedManager.addBreed(new Breed("Колли", dogs.getId()));
        breedManager.addBreed(new Breed("Кавказская овчарка", dogs.getId()));
        breedManager.addBreed(new Breed("Немецкая овчарка", dogs.getId()));
        breedManager.addBreed(new Breed("Мастиф", dogs.getId()));
        breedManager.addBreed(new Breed("Мопс", dogs.getId()));
        breedManager.addBreed(new Breed("Овчарка", dogs.getId()));
        breedManager.addBreed(new Breed("Пудель", dogs.getId()));
        breedManager.addBreed(new Breed("Русская гончая", dogs.getId()));
        breedManager.addBreed(new Breed("Сиба", dogs.getId()));
        breedManager.addBreed(new Breed("Хаски", dogs.getId()));
        breedManager.addBreed(new Breed("Спаниэль", dogs.getId()));
        breedManager.addBreed(new Breed("Такса", dogs.getId()));
        breedManager.addBreed(new Breed("Фокстерьер", dogs.getId()));
        breedManager.addBreed(new Breed("Шпитц", dogs.getId()));
    }

    public void loadAccounting() {
        MeasureResource resource = MeasureResource.getInstance();
        resource.saveOrUpdate(new Measure("гр"));
        Measure doses = new Measure("доза");
        resource.saveOrUpdate(doses);
        resource.saveOrUpdate(new Measure("единица"));
        resource.saveOrUpdate(new Measure("кг"));
        resource.saveOrUpdate(new Measure("литр"));
        resource.saveOrUpdate(new Measure("метр"));
        Measure mililiters = new Measure("мл");
        resource.saveOrUpdate(mililiters);
        resource.saveOrUpdate(new Measure("упаковка"));
        resource.saveOrUpdate(new Measure("флакон"));
        Measure units = new Measure("шт");
        resource.saveOrUpdate(units);

        SalesCategoryResource salesCategoryResource = SalesCategoryResource.getInstance();
        SalesUnitResource salesUnitResource = SalesUnitResource.getInstance();

        SalesCategory vaccines = new SalesCategory("Вакцины", SalesType.Goods, 0);
        SalesCategory food = new SalesCategory("Корма", SalesType.Goods, 0);
        SalesCategory materials = new SalesCategory("Медматериалы", SalesType.Goods, 7);
        SalesCategory medicine = new SalesCategory("Препараты", SalesType.Goods, 0);

        SalesCategory services = new SalesCategory("Услуги", SalesType.Service, 0);
        SalesCategory surgery = new SalesCategory("Хирургия", SalesType.Service, 0);

        salesCategoryResource.saveOrUpdate(vaccines);
        salesCategoryResource.saveOrUpdate(food);
        salesCategoryResource.saveOrUpdate(materials);
        salesCategoryResource.saveOrUpdate(medicine);
        salesCategoryResource.saveOrUpdate(services);
        salesCategoryResource.saveOrUpdate(surgery);

        SalesUnit nobivak = new SalesUnit("Нобивак", SalesType.Goods, vaccines.getId(), doses.getId());
        SalesUnit baitril = new SalesUnit("Байтрил", SalesType.Goods, medicine.getId(), mililiters.getId());
        SalesUnit saline = new SalesUnit("Физраствор", SalesType.Goods, medicine.getId(), units.getId());
        SalesUnit calls = new SalesUnit("Вызов", SalesType.Service, services.getId(), units.getId());

        salesUnitResource.saveOrUpdate(nobivak);
        salesUnitResource.saveOrUpdate(baitril);
        salesUnitResource.saveOrUpdate(saline);
        salesUnitResource.saveOrUpdate(calls);

        CounterAgentResource counterAgentResource = CounterAgentResource.getInstance();
        CounterAgent agent1 = new CounterAgent("Поставщик",
                "Джесси Пинкман",
                PersonType.Natural,
                "1112223344",
                "pinkman@mail.com");

        CounterAgent agent2 = new CounterAgent("Старк Энтерпрайз",
                "Старк Тони Говардович",
                PersonType.Legal,
                "1112223344",
                "stark@mail.com");

        counterAgentResource.saveOrUpdate(agent1);
        counterAgentResource.saveOrUpdate(agent2);

        Stock stock = new Stock(
            "Склад клиники",
                StockType.Selling,
                adminUser.getId(),
                firstClinic.getId()
        );

        Stock additionalStock = new Stock(
                "Хранилище",
                StockType.Storing,
                clinicUser.getId(),
                firstClinic.getId()
        );

        StockResource stockResource = StockResource.getInstance();
        stockResource.saveOrUpdate(stock);
        stockResource.saveOrUpdate(additionalStock);
    }

    public void loadDemoData() throws ValidationException {
        loadVisitResult();
        loadAnimalColors();
        loadGoodsProducers();
        loadVisitPurposes();
        loadDiagnosis();
        loadAnimals();

        ClinicManager clinicManager = ClinicManager.getInstance();
        this.firstClinic = new Clinic("Первая клиника",
                null,
                "1234567890",
                "test@test.com",
                "http://localhost:3000/",
                "Город",
                "Адрес",
                false,
                true,
                null);
        clinicManager.addClinic(firstClinic);

        this.adminUser = new Employee("Иван", "Иванович", "Иванов",
                false,
                true,
                "1112223344",
                "Ivanov@clinic.com",
                "Ул. Ивановская, 1",
                null,
                null);
        Login adminLogin = new Login("admin", "manager");

        this.clinicUser = new Employee("Пётр", "Петрович", "Петров",
                false,
                true,
                "1113334455",
                "Petrov@clinic.com",
                "Ул. Петровская, 2",
                firstClinic.getId(),
                null);
        Login additionalUserLogin = new Login("petrov", "petrov");

        EmployeeManager employeeManager = EmployeeManager.getInstance();
        employeeManager.addEmployee(adminUser, adminLogin);
        employeeManager.addEmployee(clinicUser, additionalUserLogin);

        Client client = new Client("Павел", "Павлович", "Павлов",
                                    "9998887766",
                                    "ул. Павловская",
                                    "pavlov@pav.lov");

        ClientManager clientManager = ClientManager.getInstance();
        clientManager.addClient(client);

        loadAccounting();
    }
}
