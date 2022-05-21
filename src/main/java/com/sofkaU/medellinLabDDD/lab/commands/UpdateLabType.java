package com.sofkaU.medellinLabDDD.lab.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.medellinLabDDD.lab.values.LabId;
import com.sofkaU.medellinLabDDD.lab.values.LabType;

public class UpdateLabType extends Command {
    private final LabId labId;
    private final LabType labType;

    public UpdateLabType(LabId labId, LabType labType) {
        this.labId = labId;
        this.labType = labType;
    }

    public LabId getLabId() {
        return labId;
    }

    public LabType getLabType() {
        return labType;
    }
}
