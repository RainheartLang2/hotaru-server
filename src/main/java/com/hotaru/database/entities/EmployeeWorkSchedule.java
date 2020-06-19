package com.hotaru.database.entities;

import com.hotaru.core.database.Identifiable;
import com.hotaru.core.entities.WorkSchedule;
import com.hotaru.database.converters.WorkScheduleJsonConverter;

import javax.persistence.*;

@Table(name="employeeWorkSchedule")
@Entity(name="employeeWorkSchedule")
public class EmployeeWorkSchedule implements Identifiable {

    public EmployeeWorkSchedule() {}

    public EmployeeWorkSchedule(Integer employeeId, boolean defaultSchedule, boolean usesDefault, WorkSchedule schedule) {
        this.employeeId = employeeId;
        this.defaultSchedule = defaultSchedule;
        this.usesDefault = usesDefault;
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


    @Column(name="workSchedule")
    @Convert(converter = WorkScheduleJsonConverter.class)
    private WorkSchedule schedule;

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
}
