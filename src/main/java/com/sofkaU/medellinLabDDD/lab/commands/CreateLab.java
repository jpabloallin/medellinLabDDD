package com.sofkaU.medellinLabDDD.lab.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.medellinLabDDD.lab.values.LabId;
import com.sofkaU.medellinLabDDD.lab.values.LabType;

public class CreateLab extends Command {
    private final LabId entityId;
    private final LabType labType;

    public CreateLab(LabId entityId, LabType labType) {
        this.entityId = entityId;
        this.labType = labType;
    }

    public LabId getEntityId() {
        return entityId;
    }

    public LabType getLabType() {
        return labType;
    }
}
