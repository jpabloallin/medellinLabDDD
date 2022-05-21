package com.sofkaU.medellinLabDDD.staff.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.medellinLabDDD.staff.values.Name;
import com.sofkaU.medellinLabDDD.staff.values.RecepcionistId;
import com.sofkaU.medellinLabDDD.staff.values.StaffId;

public class UpdateRecepcionistName extends Command {
    private final StaffId staffId;
    private final RecepcionistId entityId;
    private final Name name;

    public UpdateRecepcionistName(StaffId staffId, RecepcionistId entityId, Name name) {
        this.staffId = staffId;
        this.entityId = entityId;
        this.name = name;
    }

    public StaffId getStaffId() {
        return staffId;
    }

    public RecepcionistId getEntityId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }
}
