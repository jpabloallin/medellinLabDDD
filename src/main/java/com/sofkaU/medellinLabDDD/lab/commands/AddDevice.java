package com.sofkaU.medellinLabDDD.lab.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.medellinLabDDD.lab.values.DeviceId;
import com.sofkaU.medellinLabDDD.lab.values.DeviceName;
import com.sofkaU.medellinLabDDD.lab.values.LifeSpan;
import com.sofkaU.medellinLabDDD.lab.values.Model;

public class AddDevice extends Command {
    private  final DeviceId entityId;
    private  final DeviceName deviceName;
    private  final Model model;
    private  final LifeSpan lifeSpan;

    public AddDevice(DeviceId entityId, DeviceName deviceName, Model model, LifeSpan lifeSpan) {
        this.entityId = entityId;
        this.deviceName = deviceName;
        this.model = model;
        this.lifeSpan = lifeSpan;
    }

    public DeviceId getEntityId() {
        return entityId;
    }

    public DeviceName getDeviceName() {
        return deviceName;
    }

    public Model getModel() {
        return model;
    }

    public LifeSpan getLifeSpan() {
        return lifeSpan;
    }
}
