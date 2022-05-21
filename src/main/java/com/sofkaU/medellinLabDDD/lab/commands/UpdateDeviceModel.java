package com.sofkaU.medellinLabDDD.lab.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.medellinLabDDD.lab.values.DeviceId;
import com.sofkaU.medellinLabDDD.lab.values.LabId;
import com.sofkaU.medellinLabDDD.lab.values.Model;

public class UpdateDeviceModel extends Command {
    private final LabId labId;
    private final DeviceId entityId;
    private final Model model;

    public UpdateDeviceModel(LabId labId, DeviceId entityId, Model model) {
        this.labId = labId;
        this.entityId = entityId;
        this.model = model;
    }

    public LabId getLabId() {
        return labId;
    }

    public DeviceId getEntityId() {
        return entityId;
    }

    public Model getModel() {
        return model;
    }
}
