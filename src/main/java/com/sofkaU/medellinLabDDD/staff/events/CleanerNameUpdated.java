package com.sofkaU.medellinLabDDD.staff.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.medellinLabDDD.staff.values.Name;
import com.sofkaU.medellinLabDDD.staff.values.CleanerId;

public class CleanerNameUpdated extends DomainEvent {
    private final CleanerId entityId;
    private final Name name;

    public CleanerNameUpdated(CleanerId entityId, Name name) {
        super("laboratory.staff.cleanernameupdated");
        this.entityId = entityId;
        this.name = name;
    }

    public CleanerId getEntityId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }
}

