package com.sofkaU.medellinLabDDD.lab;

import co.com.sofka.domain.generic.Entity;
import com.sofkaU.medellinLabDDD.lab.values.DeviceId;
import com.sofkaU.medellinLabDDD.lab.values.DeviceName;
import com.sofkaU.medellinLabDDD.lab.values.LifeSpan;
import com.sofkaU.medellinLabDDD.lab.values.Model;

public class Device extends Entity<DeviceId> {
    private final DeviceName deviceName;
    private final Model model;
    private final LifeSpan lifeSpan;

    public Device(DeviceId entityId, DeviceName deviceName, Model model, LifeSpan lifeSpan) {
        super(entityId);
        this.deviceName = deviceName;
        this.model = model;
        this.lifeSpan = lifeSpan;
    }

    public DeviceName deviceName() {
        return deviceName;
    }

    public Model model() {
        return model;
    }

    public LifeSpan lifeSpan() {
        return lifeSpan;
    }
}
