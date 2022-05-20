package com.sofkaU.medellinLabDDD.staff.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.medellinLabDDD.staff.values.CleanerId;
import com.sofkaU.medellinLabDDD.staff.values.YearsOfExperience;

public class CleanerYearsOfExperienceUpdated extends DomainEvent {
    private final CleanerId entityId;
    private final YearsOfExperience yearsOfExperience;

    public CleanerYearsOfExperienceUpdated(CleanerId entityId, YearsOfExperience yearsOfExperience) {
        super("laboratory.staff.cleaneryearsofexperienceupdated");
        this.entityId = entityId;
        this.yearsOfExperience = yearsOfExperience;
    }

    public CleanerId getEntityId() {
        return entityId;
    }

    public YearsOfExperience getYearsOfExperience() {
        return yearsOfExperience;
    }
}
