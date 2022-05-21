package com.sofkaU.medellinLabDDD.staff;

import co.com.sofka.domain.generic.EventChange;
import com.sofkaU.medellinLabDDD.staff.events.*;

import java.util.HashSet;

public class StaffChange extends EventChange {
    public StaffChange(Staff staff) {
        apply((StaffCreated event) -> {
            staff.workArea = event.getWorkArea();
            staff.labCouriers = new HashSet<>();
            staff.cleaners = new HashSet<>();
            staff.recepcionists = new HashSet<>();
        });

        apply((WorkAreaUpdated event) -> staff.workArea = event.getWorkArea());

        apply((LabCourierAdded event) -> {
            var labCourierNumber = staff.labCouriers().size();
            if (labCourierNumber == 6) {
                throw new IllegalArgumentException("You can not add more labCouriers. You can only have 6");
            }
            staff.labCouriers.add(new LabCourier(
                    event.getEntityId(),
                    event.getName(),
                    event.getYearsOfExperience()
            ));
        });

        apply((LabCourierNameUpdated event) -> {
            var function = staff.getLabCourierById(event.getEntityId())
                    .orElseThrow(() -> new IllegalArgumentException("Staff's LabCourier was not found"));
            function.updateName(event.getName());
        });

        apply((LabCourierYearsOfExperienceUpdated event) -> {
            var function = staff.getLabCourierById(event.getEntityId())
                    .orElseThrow(() -> new IllegalArgumentException("Staff's LabCourier was not found"));
            function.updateYearsOfExperience(event.getYearsOfExperience());
        });

        apply((CleanerAdded event) -> {
            var cleanerNumber = staff.cleaners().size();
            if (cleanerNumber == 3) {
                throw new IllegalArgumentException("You can not add more cleaners. You can only have 3");
            }
            staff.cleaners.add(new Cleaner(
                    event.getEntityId(),
                    event.getName(),
                    event.getYearsOfExperience()
            ));
        });

        apply((CleanerNameUpdated event) -> {
            var function = staff.getCleanerById(event.getEntityId())
                    .orElseThrow(() -> new IllegalArgumentException("Staff's cleaner was not found"));
            function.updateName(event.getName());
        });

        apply((CleanerYearsOfExperienceUpdated event) -> {
            var function = staff.getCleanerById(event.getEntityId())
                    .orElseThrow(() -> new IllegalArgumentException("Staff's cleaner was not found"));
            function.updateYearsOfExperience(event.getYearsOfExperience());
        });

        apply((RecepcionistAdded event) -> {
            var receptionistNumber = staff.recepcionists().size();
            if (receptionistNumber == 3) {
                throw new IllegalArgumentException("You can not add more recepcionists. You can only have 3");
            }
            staff.recepcionists.add(new Recepcionist(
                    event.getEntityId(),
                    event.getName(),
                    event.getYearsOfExperience()
            ));
        });

        apply((RecepcionistNameUpdated event) -> {
            var function = staff.getRecepcionistById(event.getEntityId())
                    .orElseThrow(() -> new IllegalArgumentException("Staff's Receptionist was not found"));
            function.updateName(event.getName());
        });

        apply((RecepcionistYearsOfExperienceUpdated event) -> {
            var function = staff.getRecepcionistById(event.getEntityId())
                    .orElseThrow(() -> new IllegalArgumentException("Staff's Receptionist was not found"));
            function.updateYearsOfExperience(event.getYearsOfExperience());
        });
    }
}
