package com.sofkaU.medellinLabDDD.lab;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofkaU.medellinLabDDD.lab.events.*;
import com.sofkaU.medellinLabDDD.lab.values.*;

import java.util.Objects;
import java.util.Set;

public class Lab extends AggregateEvent<LabId> {

    protected LabType LabType;
    protected Set<Device> devices;
    protected Set<Bacteriologist> bacteriologists;
    protected Set<Bioengineer> bioengineers;
    public Lab(LabId entityId, LabType labType) {
        super(entityId);
        appendChange(new LabCreated(labType)).apply();
    }
    public void updateLabType(LabType labType) {
        appendChange(new LabTypeUpdated(labType)).apply();
    }
    public void addDevice(DeviceId entityId, DeviceName deviceName, Model model, LifeSpan lifeSpan) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(deviceName);
        Objects.requireNonNull(model);
        Objects.requireNonNull(lifeSpan);
        appendChange(new DeviceAdded(entityId, deviceName, model, lifeSpan)).apply();
    }
    public void updateDeviceName(DeviceId entityId, DeviceName deviceName) {
        appendChange(new DeviceNameUpdated(entityId, deviceName)).apply();
    }
    public void updateDeviceModel(DeviceId entityId, Model model) {
        appendChange(new DeviceModelUpdated(entityId, model)).apply();
    }
    public void updateDeviceLifeSpan(DeviceId entityId, LifeSpan lifeSpan) {
        appendChange(new DeviceLifeSpanUpdated(entityId, lifeSpan)).apply();
    }
    public void addBacteriologist(BacteriologistId entityId, Name name) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(name);
        appendChange(new DeviceAdded(entityId, name)).apply();
    }
    public void updateBacteriologistName(BacteriologistId entityId, Name name) {
        appendChange(new BacteriologistNameUpdated(entityId, name)).apply();
    }
    public void addBioengineer(BioengineerId entityId, Name name) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(name);
        appendChange(new DeviceAdded(entityId, name)).apply();
    }
    public void updateBioengineerName(BioengineerId entityId, Name name) {
        appendChange(new BioengineerNameUpdated(entityId, name)).apply();
    }
}
