package com.sofkaU.medellinLabDDD.staff.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.medellinLabDDD.staff.values.Name;
import com.sofkaU.medellinLabDDD.staff.values.RecepcionistId;

public class RecepcionistNameUpdated extends DomainEvent {
    private final RecepcionistId entityId;
    private final Name name;

    public RecepcionistNameUpdated(RecepcionistId entityId, Name name) {
        super("laboratory.staff.recepcionistnameupdated");
        this.entityId = entityId;
        this.name = name;
    }

    public RecepcionistId getEntityId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }
}
