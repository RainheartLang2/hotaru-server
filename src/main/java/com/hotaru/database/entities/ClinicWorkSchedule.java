package com.hotaru.database.entities;

import com.hotaru.core.database.Identifiable;
import com.hotaru.core.entities.WorkSchedule;
import com.hotaru.database.converters.WorkScheduleJsonConverter;

import javax.persistence.*;

@Table(name="clinicWorkSchedule")
@Entity(name="clinicWorkSchedule")
public class ClinicWorkSchedule implements Identifiable {

    public ClinicWorkSchedule() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="clinicId", unique=true)
    private Integer clinicId;

    @Column(name="isDefault")
    private boolean defaultSchedule;

    @Column(name="usesDefault")
    private boolean usesDefault;


    @Column(name="workSchedule")
    @Convert(converter = WorkScheduleJsonConverter.class)
    private WorkSchedule schedule;

    public ClinicWorkSchedule(Integer clinicId, boolean _default, boolean usesDefault, WorkSchedule schedule) {
        this.clinicId = clinicId;
        this.defaultSchedule = _default;
        this.usesDefault = usesDefault;
        this.schedule = schedule;
    }

    @Override
    public int getId() {
        return id;
    }

    public Integer getClinicId() {
        return clinicId;
    }

    public boolean isDefaultSchedule() {
        return defaultSchedule;
    }

    public boolean isUsesDefault() {
        return usesDefault;
    }

    public WorkSchedule getSchedule() {
        return schedule;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public void setClinicId(Integer clinicId) {
        this.clinicId = clinicId;
    }

    public void setDefaultSchedule(boolean _default) {
        this.defaultSchedule = _default;
    }

    public void setUsesDefault(boolean usesDefault) {
        this.usesDefault = usesDefault;
    }

    public void setSchedule(WorkSchedule schedule) {
        this.schedule = schedule;
    }
}
