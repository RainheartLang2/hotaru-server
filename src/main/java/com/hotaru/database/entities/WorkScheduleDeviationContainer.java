package com.hotaru.database.entities;

import com.hotaru.business.logic.enums.DeviationType;
import com.hotaru.core.database.Identifiable;
import com.hotaru.core.entities.DaySchedule;
import com.hotaru.database.converters.DayScheduleJsonConverter;

import javax.persistence.*;
import java.util.Date;

@Table(name="workScheduleDeviation")
@Entity(name="workScheduleDeviation")
public class WorkScheduleDeviationContainer implements Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name", length = 100)
    private String name;

    @Column(name="workScheduleId")
    private Integer workScheduleId;

    @Column(name="type")
    private DeviationType type;

    @Column(name="startDate")
    private Date startDate;

    @Column(name="endDate")
    private Date endDate;

    @Column(name="changes")
    @Convert(converter = DayScheduleJsonConverter.class)
    private DaySchedule changes;

    public WorkScheduleDeviationContainer() {}

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

    public void setDeviationData(Date startDate, Date endDate, DaySchedule changes) {
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setChanges(changes);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public DeviationType getType() {
        return type;
    }

    public void setType(DeviationType type) {
        this.type = type;
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

    public DaySchedule getChanges() {
        return changes;
    }

    public void setChanges(DaySchedule changes) {
        this.changes = changes;
    }
}
