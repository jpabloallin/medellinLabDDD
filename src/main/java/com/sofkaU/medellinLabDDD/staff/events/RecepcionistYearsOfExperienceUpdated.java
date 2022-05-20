package com.sofkaU.medellinLabDDD.staff.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.medellinLabDDD.staff.values.RecepcionistId;
import com.sofkaU.medellinLabDDD.staff.values.YearsOfExperience;

public class RecepcionistYearsOfExperienceUpdated extends DomainEvent {
    private final RecepcionistId entityId;
    private final YearsOfExperience yearsOfExperience;

    public RecepcionistYearsOfExperienceUpdated(RecepcionistId entityId, YearsOfExperience yearsOfExperience) {
        super("laboratory.staff.recepcionistyearsofexperienceupdated");
        this.entityId = entityId;
        this.yearsOfExperience = yearsOfExperience;
    }

    public RecepcionistId getEntityId() {
        return entityId;
    }

    public YearsOfExperience getYearsOfExperience() {
        return yearsOfExperience;
    }
}
