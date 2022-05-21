package com.sofkaU.medellinLabDDD.lab.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.medellinLabDDD.lab.values.*;

public class AddDevice extends Command {
    private  final LabId labId;
    private final DeviceId deviceId;
    private  final DeviceName deviceName;
    private  final Model model;
    private  final LifeSpan lifeSpan;

    public AddDevice(LabId labId, DeviceId deviceId, DeviceName deviceName, Model model, LifeSpan lifeSpan) {
        this.labId = labId;
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.model = model;
        this.lifeSpan = lifeSpan;
    }

    public LabId getLabId() {
        return labId;
    }

    public DeviceId getDeviceId() {
        return deviceId;
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
