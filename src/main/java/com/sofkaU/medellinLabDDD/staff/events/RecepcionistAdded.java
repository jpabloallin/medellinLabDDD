package com.sofkaU.medellinLabDDD.staff.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.medellinLabDDD.lab.values.Name;
import com.sofkaU.medellinLabDDD.staff.values.RecepcionistId;
import com.sofkaU.medellinLabDDD.staff.values.YearsOfExperience;

public class RecepcionistAdded extends DomainEvent {
    private final RecepcionistId entityId;
    private final Name name;
    private final YearsOfExperience yearsOfExperience;

    public RecepcionistAdded(RecepcionistId entityId, Name name, YearsOfExperience yearsOfExperience) {
        super("laboratory.staff.recepcionistadded");
        this.entityId = entityId;
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
    }

    public RecepcionistId getEntityId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }

    public YearsOfExperience getYearsOfExperience() {
        return yearsOfExperience;
    }
}
