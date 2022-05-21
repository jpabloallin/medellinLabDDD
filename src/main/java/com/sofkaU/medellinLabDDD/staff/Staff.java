package com.sofkaU.medellinLabDDD.staff;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.medellinLabDDD.lab.Lab;
import com.sofkaU.medellinLabDDD.lab.LabChange;
import com.sofkaU.medellinLabDDD.lab.values.LabId;
import com.sofkaU.medellinLabDDD.lab.values.Name;
import com.sofkaU.medellinLabDDD.staff.events.*;
import com.sofkaU.medellinLabDDD.staff.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Staff  extends AggregateEvent<StaffId> {
    protected WorkArea workArea;
    protected Set<LabCourier> labCouriers;
    protected Set<Cleaner> cleaners;
    protected Set<Recepcionist> recepcionists;
    public Staff(StaffId entityId, WorkArea workArea) {
        super(entityId);
        appendChange(new StaffCreated(workArea)).apply();
    }
    private Staff(StaffId entityId){
        super(entityId);
        subscribe(new StaffChange(this));
    }
    /*
     * This method allows me to build a Staff aggregate object with saved events
     */
    public static Staff from(StaffId staffId, List<DomainEvent> events) {
        var staff = new Staff(staffId);
        events.forEach(staff::applyEvent);
        return staff;
    }
    public void updateWorkArea(WorkArea workArea) {
        appendChange(new WorkAreaUpdated(workArea)).apply();
    }
    public void addLabCourier(LabCourierId entityId, Name name, YearsOfExperience yearsOfExperience) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(yearsOfExperience);
        appendChange(new LabCourierAdded(entityId, name, yearsOfExperience)).apply();
    }
    public void updateLabCourierName(LabCourierId entityId, Name name) {
        appendChange(new LabCourierNameUpdated(entityId, name)).apply();
    }
    public void updateLabCourierYearsOfExperience(LabCourierId entityId, YearsOfExperience yearsOfExperience) {
        appendChange(new LabCourierYearsOfExperienceUpdated(entityId, yearsOfExperience)).apply();
    }
    public void addCleaner(CleanerId entityId, Name name, YearsOfExperience yearsOfExperience) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(yearsOfExperience);
        appendChange(new CleanerAdded(entityId, name, yearsOfExperience)).apply();
    }
    public void updateCleanerName(CleanerId entityId, Name name) {
        appendChange(new CleanerNameUpdated(entityId, name)).apply();
    }
    public void updateCleanerYearsOfExperience(CleanerId entityId, YearsOfExperience yearsOfExperience) {
        appendChange(new CleanerYearsOfExperienceUpdated(entityId, yearsOfExperience)).apply();
    }
    public void addRecepcionist(RecepcionistId entityId, Name name, YearsOfExperience yearsOfExperience) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(yearsOfExperience);
        appendChange(new RecepcionistAdded(entityId, name, yearsOfExperience)).apply();
    }
    public void updateRecepcionistName(RecepcionistId entityId, Name name) {
        appendChange(new RecepcionistNameUpdated(entityId, name)).apply();
    }
    public void updateRecepcionistYearsOfExperience(RecepcionistId entityId, YearsOfExperience yearsOfExperience) {
        appendChange(new RecepcionistYearsOfExperienceUpdated(entityId, yearsOfExperience)).apply();
    }

    public Optional<LabCourier> getLabCourierById(LabCourierId entityId) {
        return labCouriers()
                .stream()
                .filter(labCourier -> labCourier.identity().equals(entityId))
                .findFirst();
    }

    public Optional<Cleaner> getCleanerById(CleanerId entityId) {
        return cleaners()
                .stream()
                .filter(cleaner -> cleaner.identity().equals(entityId))
                .findFirst();
    }
    public Optional<Recepcionist> getRecepcionistById(RecepcionistId entityId) {
        return recepcionists()
                .stream()
                .filter(receptionist -> receptionist.identity().equals(entityId))
                .findFirst();
    }
    public WorkArea workArea() {
        return workArea;
    }

    public Set<LabCourier> labCouriers() {
        return labCouriers;
    }

    public Set<Cleaner> cleaners() {
        return cleaners;
    }

    public Set<Recepcionist> recepcionists() {
        return recepcionists;
    }
}
