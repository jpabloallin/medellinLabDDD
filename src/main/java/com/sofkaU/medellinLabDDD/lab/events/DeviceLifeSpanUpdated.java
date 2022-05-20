package com.sofkaU.medellinLabDDD.lab.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.medellinLabDDD.lab.values.DeviceId;
import com.sofkaU.medellinLabDDD.lab.values.LifeSpan;

public class DeviceLifeSpanUpdated extends DomainEvent {
    private final DeviceId entityId;
    private final LifeSpan lifeSpan;

    public DeviceLifeSpanUpdated(DeviceId entityId, LifeSpan lifeSpan) {
        super("laboratory.lab.devicelifespanppdated");
        this.entityId = entityId;
        this.lifeSpan = lifeSpan;
    }

    public DeviceId getEntityId() {
        return entityId;
    }

    public LifeSpan getLifeSpan() {
        return lifeSpan;
    }
}
