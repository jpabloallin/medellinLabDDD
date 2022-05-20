package com.sofkaU.medellinLabDDD.lab.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.medellinLabDDD.lab.values.DeviceId;
import com.sofkaU.medellinLabDDD.lab.values.Model;

public class DeviceModelUpdated extends DomainEvent {
    private final DeviceId entityId;
    private final Model model;

    public DeviceModelUpdated(DeviceId entityId, Model model) {
        super("laboratory.lab.devicemodelupdated");
        this.entityId = entityId;
        this.model = model;
    }

    public DeviceId getEntityId() {
        return entityId;
    }

    public Model getModel() {
        return model;
    }
}
