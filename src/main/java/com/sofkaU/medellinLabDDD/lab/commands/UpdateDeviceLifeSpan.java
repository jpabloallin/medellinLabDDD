package com.sofkaU.medellinLabDDD.lab.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.medellinLabDDD.lab.values.DeviceId;
import com.sofkaU.medellinLabDDD.lab.values.LabId;
import com.sofkaU.medellinLabDDD.lab.values.LifeSpan;

public class UpdateDeviceLifeSpan extends Command {
    private final LabId labId;
    private final DeviceId entityId;
    private final LifeSpan lifeSpan;

    public UpdateDeviceLifeSpan(LabId labId, DeviceId entityId, LifeSpan lifeSpan) {
        this.labId = labId;
        this.entityId = entityId;
        this.lifeSpan = lifeSpan;
    }

    public LabId getLabId() {
        return labId;
    }

    public DeviceId getEntityId() {
        return entityId;
    }

    public LifeSpan getLifeSpan() {
        return lifeSpan;
    }
}
