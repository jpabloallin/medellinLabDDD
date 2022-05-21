package com.sofkaU.medellinLabDDD.lab.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.medellinLabDDD.lab.values.BacteriologistId;
import com.sofkaU.medellinLabDDD.lab.values.LabId;
import com.sofkaU.medellinLabDDD.lab.values.Name;

public class UpdateBacteriologistName extends Command {
    private final LabId labId;
    private final BacteriologistId entityId;
    private final Name name;

    public UpdateBacteriologistName(LabId labId, BacteriologistId entityId, Name name) {
        this.labId = labId;
        this.entityId = entityId;
        this.name = name;
    }

    public LabId getLabId() {
        return labId;
    }

    public BacteriologistId getEntityId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }
}
