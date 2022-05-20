package com.sofkaU.medellinLabDDD.lab.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.medellinLabDDD.lab.values.BacteriologistId;
import com.sofkaU.medellinLabDDD.lab.values.Name;

public class BacteriologistAdded extends DomainEvent {
    private final BacteriologistId entityId;
    private final Name name;

    public BacteriologistAdded(BacteriologistId entityId, Name name) {
        super("laboratory.lab.bacteriologistadded");
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
