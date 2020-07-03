package com.hotaru.core.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.googlecode.jsonrpc4j.JsonRpcMultiServer;
import com.hotaru.business.logic.Settings;
import com.hotaru.business.managers.DemoDataManager;
import com.hotaru.business.managers.SettingsManager;
import com.hotaru.core.database.SessionFactoryHolder;
import com.hotaru.core.exceptions.ValidationException;
import com.hotaru.rpc.EmployeeService;
import com.hotaru.rpc.animalColor.AnimalColorService;
import com.hotaru.rpc.appointment.AppointmentService;
import com.hotaru.rpc.breed.BreedService;
import com.hotaru.rpc.client.ClientService;
import com.hotaru.rpc.clinic.ClinicService;
import com.hotaru.rpc.clinicWorkSchedule.ClinicWorkScheduleService;
import com.hotaru.rpc.diagnosis.DiagnosisService;
import com.hotaru.rpc.employeeWorkSchedule.EmployeeWorkScheduleService;
import com.hotaru.rpc.measure.MeasureService;
import com.hotaru.rpc.pet.PetService;
import com.hotaru.rpc.plannedCall.PlannedCallService;
import com.hotaru.rpc.profile.UserProfileService;
import com.hotaru.rpc.salesCategory.SalesCategoryService;
import com.hotaru.rpc.species.SpeciesService;
import com.hotaru.rpc.visitPurpose.VisitPurposeService;
import com.hotaru.rpc.visitResult.VisitResultService;
import org.hibernate.Session;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserZoneServlet extends HttpServlet {
    private JsonRpcMultiServer jsonRpcServer;

    private void loadDemoData() throws ValidationException {
        Session session = SessionFactoryHolder.getSession();
        session.beginTransaction();
        try {
            SettingsManager settingsManager = SettingsManager.getInstance();
            boolean demoDataLoaded = settingsManager.getBooleanSetting(Settings.DEMO_DATA_LOADED);
            if (!demoDataLoaded) {
                DemoDataManager.getInstance().loadDemoData();
                settingsManager.setBooleanSetting(Settings.DEMO_DATA_LOADED, true);
            }
        } finally {
            session.getTransaction().commit();
        }
    }

    public void init(ServletConfig config) {
        try {
            loadDemoData();
        } catch (ValidationException e) {
            e.printStackTrace();
        }

        this.jsonRpcServer = new JsonRpcMultiServer(new ObjectMapper());
        jsonRpcServer.addService("EmployeeService", new EmployeeService(), EmployeeService.class);
        jsonRpcServer.addService("UserProfileService", new UserProfileService(), UserProfileService.class);
        jsonRpcServer.addService("ClinicService", new ClinicService(), ClinicService.class);
        jsonRpcServer.addService("SpeciesService", new SpeciesService(), SpeciesService.class);
        jsonRpcServer.addService("BreedService", new BreedService(), BreedService.class);
        jsonRpcServer.addService("AppointmentService", new AppointmentService(), AppointmentService.class);
        jsonRpcServer.addService("ClientService", new ClientService(), ClientService.class);
        jsonRpcServer.addService("MeasureService", new MeasureService(), MeasureService.class);
        jsonRpcServer.addService("VisitResultService", new VisitResultService(), VisitResultService.class);
        jsonRpcServer.addService("VisitPurposeService", new VisitPurposeService(), VisitPurposeService.class);
        jsonRpcServer.addService("DiagnosisService", new DiagnosisService(), DiagnosisService.class);
        jsonRpcServer.addService("AnimalColorService", new AnimalColorService(), AnimalColorService.class);
        jsonRpcServer.addService("ClinicWorkScheduleService", new ClinicWorkScheduleService(), ClinicWorkScheduleService.class);
        jsonRpcServer.addService("EmployeeWorkScheduleService", new EmployeeWorkScheduleService(), EmployeeWorkScheduleService.class);
        jsonRpcServer.addService("PetService", new PetService(), PetService.class);
        jsonRpcServer.addService("PlannedCallService", new PlannedCallService(), PlannedCallService.class);
        jsonRpcServer.addService(SalesCategoryService.class.getSimpleName(), new SalesCategoryService(), SalesCategoryService.class);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.jsonRpcServer.handle(req, resp);
    }
}
