package com.sofkaU.medellinLabDDD.lab;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.medellinLabDDD.lab.events.*;
import com.sofkaU.medellinLabDDD.lab.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
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
    private Lab(LabId entityId){
        super(entityId);
        subscribe(new LabChange(this));
    }

    /*
     * This method allows me to build a Lab aggregate object with saved events
     */
    public static Lab from(LabId labId, List<DomainEvent> events) {
       var lab = new Lab(labId);
       events.forEach(lab::applyEvent);
       return lab;
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
        appendChange(new BacteriologistAdded(entityId, name)).apply();
    }
    public void updateBacteriologistName(BacteriologistId entityId, Name name) {
        appendChange(new BacteriologistNameUpdated(entityId, name)).apply();
    }
    public void addBioengineer(BioengineerId entityId, Name name) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(name);
        appendChange(new BioengineerAdded(entityId, name)).apply();
    }
    public void updateBioengineerName(BioengineerId entityId, Name name) {
        appendChange(new BioengineerNameUpdated(entityId, name)).apply();
    }
    public Optional<Device> getDeviceById(DeviceId entityId) {
        return devices()
                .stream()
                .filter(device -> device.identity().equals(entityId))
                .findFirst();
    }

    public Optional<Bacteriologist> getBacteriologistById(BacteriologistId entityId) {
        return bacteriologists()
                .stream()
                .filter(bacteriologist -> bacteriologist.identity().equals(entityId))
                .findFirst();
    }
    public Optional<Bioengineer> getBioengineerById(BioengineerId entityId) {
        return bioengineers()
                .stream()
                .filter(bioengineer -> bioengineer.identity().equals(entityId))
                .findFirst();
    }
    public LabType labType() {
        return LabType;
    }

    public Set<Device> devices() {
        return devices;
    }

    public Set<Bacteriologist> bacteriologists() {
        return bacteriologists;
    }

    public Set<Bioengineer> bioengineers() {
        return bioengineers;
    }
}
