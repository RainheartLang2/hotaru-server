package com.hotaru.database.entities;

import com.hotaru.core.database.Identifiable;
import com.hotaru.core.entities.WorkScheduleDeviation;
import com.hotaru.database.converters.ScheduleDeviationJsonConverter;

import javax.persistence.*;

@Table(name="clinicScheduleDeviation")
@Entity(name="clinicScheduleDeviation")
public class ClinicScheduleDeviation implements Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name", length = 100)
    private String name;

    @Column(name="workScheduleId")
    private Integer workScheduleId;

    @Column(name="deviationData")
    @Convert(converter = ScheduleDeviationJsonConverter.class)
    private WorkScheduleDeviation deviationData;

    public ClinicScheduleDeviation() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWorkScheduleId() {
        return workScheduleId;
    }

    public void setWorkScheduleId(Integer clinicId) {
        this.workScheduleId = clinicId;
    }

    public WorkScheduleDeviation getDeviationData() {
        return deviationData;
    }

    public void setDeviationData(WorkScheduleDeviation deviationData) {
        this.deviationData = deviationData;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
