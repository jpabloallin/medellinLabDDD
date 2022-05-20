package com.sofkaU.medellinLabDDD.staff;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofkaU.medellinLabDDD.lab.events.DeviceModelUpdated;
import com.sofkaU.medellinLabDDD.lab.events.DeviceNameUpdated;
import com.sofkaU.medellinLabDDD.lab.events.LabTypeUpdated;
import com.sofkaU.medellinLabDDD.lab.values.*;
import com.sofkaU.medellinLabDDD.lab.values.Name;
import com.sofkaU.medellinLabDDD.staff.events.*;
import com.sofkaU.medellinLabDDD.staff.values.*;

import java.util.Objects;
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
}
