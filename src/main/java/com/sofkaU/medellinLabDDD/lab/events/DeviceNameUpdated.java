package com.sofkaU.medellinLabDDD.lab.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.medellinLabDDD.lab.values.DeviceId;
import com.sofkaU.medellinLabDDD.lab.values.DeviceName;

public class DeviceNameUpdated extends DomainEvent {
    private final DeviceId entityId;
    private final DeviceName deviceName;

    public DeviceNameUpdated(DeviceId entityId, DeviceName deviceName) {
        super("laboratory.lab.devicenameupdated");
        this.entityId = entityId;
        this.deviceName = deviceName;
    }

    public DeviceId getEntityId() {
        return entityId;
    }

    public DeviceName getDeviceName() {
        return deviceName;
    }
}
