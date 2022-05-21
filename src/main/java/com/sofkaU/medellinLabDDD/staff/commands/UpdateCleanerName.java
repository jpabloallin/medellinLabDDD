package com.sofkaU.medellinLabDDD.staff.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.medellinLabDDD.staff.values.CleanerId;
import com.sofkaU.medellinLabDDD.staff.values.Name;
import com.sofkaU.medellinLabDDD.staff.values.StaffId;

public class UpdateCleanerName extends Command {
    private final StaffId staffId;
    private final CleanerId entityId;
    private final Name name;

    public UpdateCleanerName(StaffId staffId, CleanerId entityId, Name name) {
        this.staffId = staffId;
        this.entityId = entityId;
        this.name = name;
    }

    public StaffId getStaffId() {
        return staffId;
    }

    public CleanerId getEntityId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }
}
