package com.sofkaU.medellinLabDDD.lab.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.medellinLabDDD.lab.values.LabType;

public class LabCreated extends DomainEvent {
    private final LabType labType;

    public LabCreated(LabType labType) {
        super("laboratory.lab.labcreated");
        this.labType = labType;
    }

    public LabType getLabType() {
        return labType;
    }
}
