package com.sofkaU.medellinLabDDD.staff.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.medellinLabDDD.staff.values.Name;
import com.sofkaU.medellinLabDDD.staff.values.LabCourierId;

public class LabCourierNameUpdated extends DomainEvent {
    private final LabCourierId entityId;
    private final Name name;

    public LabCourierNameUpdated(LabCourierId entityId, Name name) {
        super("laboratory.staff.labouriernameupdated");
        this.entityId = entityId;
        this.name = name;
    }

    public LabCourierId getEntityId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }
}
