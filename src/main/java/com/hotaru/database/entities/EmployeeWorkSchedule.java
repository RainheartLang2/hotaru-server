package com.hotaru.database.entities;

import com.hotaru.core.database.Identifiable;
import com.hotaru.core.entities.WorkSchedule;
import com.hotaru.database.converters.WorkScheduleJsonConverter;

import javax.persistence.*;
import java.util.Date;

@Table(name="employeeWorkSchedule")
@Entity(name="employeeWorkSchedule")
public class EmployeeWorkSchedule implements Identifiable {

    public EmployeeWorkSchedule() {}

    public EmployeeWorkSchedule(Integer employeeId, Date startDate, boolean defaultSchedule, boolean usesDefault, WorkSchedule schedule) {
        this.employeeId = employeeId;
        this.defaultSchedule = defaultSchedule;
        this.usesDefault = usesDefault;
        this.startDate = startDate;
        this.schedule = schedule;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="employeeId")
    private Integer employeeId;

    @Column(name="isDefault")
    private boolean defaultSchedule;

    @Column(name="usesDefault")
    private boolean usesDefault;


    @Column(name="workSchedule", length = 1024)
    @Convert(converter = WorkScheduleJsonConverter.class)
    private WorkSchedule schedule;

    @Column(name="startDate")
    private Date startDate;

    @Column(name="endDate")
    private Date endDate;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public boolean isDefaultSchedule() {
        return defaultSchedule;
    }

    public void setDefaultSchedule(boolean defaultSchedule) {
        this.defaultSchedule = defaultSchedule;
    }

    public boolean isUsesDefault() {
        return usesDefault;
    }

    public void setUsesDefault(boolean usesDefault) {
        this.usesDefault = usesDefault;
    }

    public WorkSchedule getSchedule() {
        return schedule;
    }

    public void setSchedule(WorkSchedule schedule) {
        this.schedule = schedule;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
