package com.sofkaU.medellinLabDDD.lab.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.medellinLabDDD.lab.values.LabType;

public class LabTypeUpdated extends DomainEvent {
    private final LabType labType;

    public LabTypeUpdated(LabType labType) {
        super("laboratory.lab.labtypeupdated");
        this.labType = labType;
    }

    public LabType getLabType() {
        return labType;
    }
}
