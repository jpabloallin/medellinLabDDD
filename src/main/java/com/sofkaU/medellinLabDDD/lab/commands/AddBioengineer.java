package com.sofkaU.medellinLabDDD.lab.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.medellinLabDDD.lab.values.BioengineerId;
import com.sofkaU.medellinLabDDD.lab.values.LabId;
import com.sofkaU.medellinLabDDD.lab.values.Name;

public class AddBioengineer extends Command {
    private final LabId labId;
    private final BioengineerId entityId;
    private final Name name;

    public AddBioengineer(LabId labId, BioengineerId entityId, Name name) {
        this.labId = labId;
        this.entityId = entityId;
        this.name = name;
    }

    public LabId getLabId() {
        return labId;
    }

    public BioengineerId getEntityId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }
}
