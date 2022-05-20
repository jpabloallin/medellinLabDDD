package com.sofkaU.medellinLabDDD.lab.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.medellinLabDDD.lab.values.BioengineerId;
import com.sofkaU.medellinLabDDD.lab.values.Name;

public class BioengineerNameUpdated extends DomainEvent {
    private final BioengineerId entityId;
    private final Name name;

    public BioengineerNameUpdated(BioengineerId entityId, Name name) {
        super("laboratory.lab.bioengineernameppdated");
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
