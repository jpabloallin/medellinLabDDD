package com.sofkaU.medellinLabDDD.staff.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.medellinLabDDD.staff.values.Name;
import com.sofkaU.medellinLabDDD.staff.values.LabCourierId;
import com.sofkaU.medellinLabDDD.staff.values.YearsOfExperience;

public class LabCourierAdded extends DomainEvent {
    private final LabCourierId entityId;
    private final Name name;
    private final YearsOfExperience yearsOfExperience;

    public LabCourierAdded(LabCourierId entityId, Name name, YearsOfExperience yearsOfExperience) {
        super("laboratory.staff.labcourieradded");
        this.entityId = entityId;
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
    }

    public LabCourierId getEntityId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }

    public YearsOfExperience getYearsOfExperience() {
        return yearsOfExperience;
    }
}
