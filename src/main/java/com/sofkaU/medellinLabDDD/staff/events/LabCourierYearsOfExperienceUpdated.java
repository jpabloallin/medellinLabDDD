package com.sofkaU.medellinLabDDD.staff.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.medellinLabDDD.staff.values.LabCourierId;
import com.sofkaU.medellinLabDDD.staff.values.YearsOfExperience;

public class LabCourierYearsOfExperienceUpdated extends DomainEvent {
    private final LabCourierId entityId;
    private final YearsOfExperience yearsOfExperience;

    public LabCourierYearsOfExperienceUpdated(LabCourierId entityId, YearsOfExperience yearsOfExperience) {
        super("laboratory.staff.labcourieryearsofexperienceupdated");
        this.entityId = entityId;
        this.yearsOfExperience = yearsOfExperience;
    }

    public LabCourierId getEntityId() {
        return entityId;
    }

    public YearsOfExperience getYearsOfExperience() {
        return yearsOfExperience;
    }
}
