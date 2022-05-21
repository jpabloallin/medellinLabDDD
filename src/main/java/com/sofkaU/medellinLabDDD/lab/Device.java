package com.sofkaU.medellinLabDDD.lab;

import co.com.sofka.domain.generic.Entity;
import com.sofkaU.medellinLabDDD.lab.values.DeviceId;
import com.sofkaU.medellinLabDDD.lab.values.DeviceName;
import com.sofkaU.medellinLabDDD.lab.values.LifeSpan;
import com.sofkaU.medellinLabDDD.lab.values.Model;

import java.util.Objects;

public class Device extends Entity<DeviceId> {
    private DeviceName deviceName;
    private Model model;
    private LifeSpan lifeSpan;

    public Device(DeviceId entityId, DeviceName deviceName, Model model, LifeSpan lifeSpan) {
        super(entityId);
        this.deviceName = deviceName;
        this.model = model;
        this.lifeSpan = lifeSpan;
    }
    public void updateDeviceName(DeviceName deviceName) {
        this.deviceName = Objects.requireNonNull(deviceName);
    }
    public void updateModel(Model model) {
        this.model = Objects.requireNonNull(model);
    }
    public void updateLifeSpan(LifeSpan lifeSpan) {
        this.lifeSpan =Objects.requireNonNull(lifeSpan);
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
