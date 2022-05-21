package com.sofkaU.medellinLabDDD.staff.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.medellinLabDDD.staff.values.StaffId;
import com.sofkaU.medellinLabDDD.staff.values.WorkArea;

public class CreateStuff extends Command {
    private final StaffId entityId;
    private final WorkArea workArea;

    public CreateStuff(StaffId entityId, WorkArea workArea) {
        this.entityId = entityId;
        this.workArea = workArea;
    }

    public StaffId getEntityId() {
        return entityId;
    }

    public WorkArea getWorkArea() {
        return workArea;
    }
}
