package com.sofkaU.medellinLabDDD.lab.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.medellinLabDDD.lab.values.BioengineerId;
import com.sofkaU.medellinLabDDD.lab.values.Name;

public class BioengineerAdded extends DomainEvent {
    private final BioengineerId entityId;
    private final Name name;

    public BioengineerAdded(BioengineerId entityId, Name name) {
        super("laboratory.lab.bioengineeradded");
        this.entityId = entityId;
        this.name = name;
    }

    public BioengineerId getEntityId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }
}
