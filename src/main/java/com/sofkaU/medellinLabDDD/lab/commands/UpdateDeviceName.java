package com.sofkaU.medellinLabDDD.lab.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.medellinLabDDD.lab.values.DeviceId;
import com.sofkaU.medellinLabDDD.lab.values.DeviceName;
import com.sofkaU.medellinLabDDD.lab.values.LabId;

public class UpdateDeviceName extends Command {
    private final LabId labId;
    private final DeviceId entityId;
    private final DeviceName deviceName;

    public UpdateDeviceName(LabId labId, DeviceId entityId, DeviceName deviceName) {
        this.labId = labId;
        this.entityId = entityId;
        this.deviceName = deviceName;
    }

    public LabId getLabId() {
        return labId;
    }

    public DeviceId getEntityId() {
        return entityId;
    }

    public DeviceName getDeviceName() {
        return deviceName;
    }
}
