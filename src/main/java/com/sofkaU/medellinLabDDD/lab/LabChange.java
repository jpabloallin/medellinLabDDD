package com.sofkaU.medellinLabDDD.lab;

import co.com.sofka.domain.generic.EventChange;
import com.sofkaU.medellinLabDDD.lab.events.*;

import java.util.HashSet;

public class LabChange extends EventChange {
    public LabChange(Lab lab) {

        apply((LabCreated event) -> {
            lab.LabType = event.getLabType();
            lab.devices = new HashSet<>();
            lab.bacteriologists = new HashSet<>();
            lab.bioengineers = new HashSet<>();
        });

        apply((LabTypeUpdated event) -> lab.LabType = event.getLabType());

        /*
        * Device
        * */
        apply((DeviceAdded event) -> {
            var deviceNumber = lab.devices().size();
            if (deviceNumber == 30) {
                throw new IllegalArgumentException("You can not add more devices. You can only have 30 devices");
            }
            lab.devices.add(new Device(
                    event.getEntityId(),
                    event.getDeviceName(),
                    event.getModel(),
                    event.getLifeSpan()
            ));
        });

        apply((DeviceNameUpdated event) -> {
            var function = lab.getDeviceById(event.getEntityId())
                    .orElseThrow(() -> new IllegalArgumentException("Lab's device was not found"));
            function.updateDeviceName(event.getDeviceName());
        });

        apply((DeviceModelUpdated event) -> {
            var function = lab.getDeviceById(event.getEntityId())
                    .orElseThrow(() -> new IllegalArgumentException("Lab's device was not found"));
            function.updateModel(event.getModel());
        });

        apply((DeviceLifeSpanUpdated event) -> {
            var function = lab.getDeviceById(event.getEntityId())
                    .orElseThrow(() -> new IllegalArgumentException("Lab's device was not found"));
            function.updateLifeSpan(event.getLifeSpan());
        });

        /*
        * Bacteriologist
        * */
        apply((BacteriologistAdded event) -> {
            var bacteriologistNumber = lab.bacteriologists().size();
            if (bacteriologistNumber == 15) {
                throw new IllegalArgumentException("You can not add more bacteriologists. You can only have 15");
            }
            lab.bacteriologists.add(new Bacteriologist(
                    event.getEntityId(),
                    event.getName()
            ));
        });

        apply((BacteriologistNameUpdated event) -> {
            var function = lab.getBacteriologistById(event.getEntityId())
                    .orElseThrow(() -> new IllegalArgumentException("Lab's Bacteriologist was not found"));
            function.updateName(event.getName());
        });

        /*
        * Bioengineer
        * */
        apply((BioengineerAdded event) -> {
            var bioengineerNumber = lab.bioengineers().size();
            if (bioengineerNumber == 3) {
                throw new IllegalArgumentException("You can not add more bioengineers. You can only have 3");
            }
            lab.bioengineers.add(new Bioengineer(
                    event.getEntityId(),
                    event.getName()
            ));
        });

        apply((BioengineerNameUpdated event) -> {
            var function = lab.getBioengineerById(event.getEntityId())
                    .orElseThrow(() -> new IllegalArgumentException("Lab's Bioengineer was not found"));
            function.updateName(event.getName());
        });
    }
}
