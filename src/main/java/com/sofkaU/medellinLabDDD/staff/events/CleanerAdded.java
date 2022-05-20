package com.sofkaU.medellinLabDDD.staff.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.medellinLabDDD.lab.values.Name;
import com.sofkaU.medellinLabDDD.staff.values.CleanerId;
import com.sofkaU.medellinLabDDD.staff.values.YearsOfExperience;

public class CleanerAdded extends DomainEvent {
    private final CleanerId entityId;
    private final Name name;
    private final YearsOfExperience yearsOfExperience;

    public CleanerAdded(CleanerId entityId, Name name, YearsOfExperience yearsOfExperience) {
        super("laboratory.staff.cleaneradded");
        this.entityId = entityId;
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
    }

    public CleanerId getEntityId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }

    public YearsOfExperience getYearsOfExperience() {
        return yearsOfExperience;
    }
}
