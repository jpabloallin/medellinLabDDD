package com.sofkaU.medellinLabDDD.lab.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.medellinLabDDD.lab.values.BacteriologistId;
import com.sofkaU.medellinLabDDD.lab.values.Name;

public class BacteriologistNameUpdated extends DomainEvent {
    private final BacteriologistId entityId;
    private final Name name;

    public BacteriologistNameUpdated(BacteriologistId entityId, Name name) {
        super("laboratory.lab.bacteriologistnameupdated");
        this.entityId = entityId;
        this.name = name;
    }

    public BacteriologistId getEntityId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }
}
