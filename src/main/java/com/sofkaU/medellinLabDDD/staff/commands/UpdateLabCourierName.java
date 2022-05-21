package com.sofkaU.medellinLabDDD.staff.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.medellinLabDDD.staff.values.LabCourierId;
import com.sofkaU.medellinLabDDD.staff.values.Name;
import com.sofkaU.medellinLabDDD.staff.values.StaffId;

public class UpdateLabCourierName extends Command {
    private final StaffId staffId;
    private final LabCourierId entityId;
    private final Name name;

    public UpdateLabCourierName(StaffId staffId, LabCourierId entityId, Name name) {
        this.staffId = staffId;
        this.entityId = entityId;
        this.name = name;
    }

    public StaffId getStaffId() {
        return staffId;
    }

    public LabCourierId getEntityId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }
}
