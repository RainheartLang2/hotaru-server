package com.hotaru.database.entities;

import com.hotaru.core.database.Identifiable;
import com.hotaru.core.entities.WorkSchedule;
import com.hotaru.database.converters.DataBaseJsonConverter;

import javax.persistence.*;

@Table(name="clinicWorkSchedule")
@Entity(name="clinicWorkSchedule")
public class ClinicWorkSchedule implements Identifiable {

    public ClinicWorkSchedule() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="clinicId")
    private Integer clinicId;

    @Column(name="isDefault")
    private boolean _default;

    @Column(name="usesDefault")
    private boolean usesDefault;


    @Column(name="workSchedule")
    @Convert(converter = DataBaseJsonConverter.class)
    private WorkSchedule schedule;

    public ClinicWorkSchedule(Integer clinicId, boolean _default, boolean usesDefault, WorkSchedule schedule) {
        this.clinicId = clinicId;
        this._default = _default;
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

    public boolean is_default() {
        return _default;
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

    public void set_default(boolean _default) {
        this._default = _default;
    }

    public void setUsesDefault(boolean usesDefault) {
        this.usesDefault = usesDefault;
    }

    public void setSchedule(WorkSchedule schedule) {
        this.schedule = schedule;
    }
}
