package com.sofkaU.medellinLabDDD.staff.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.medellinLabDDD.staff.values.LabCourierId;
import com.sofkaU.medellinLabDDD.staff.values.StaffId;
import com.sofkaU.medellinLabDDD.staff.values.YearsOfExperience;

public class UpdateLabCourierYearsOfExperience extends Command {
    private final StaffId staffId;
    private final LabCourierId entityId;
    private final YearsOfExperience yearsOfExperience;

    public UpdateLabCourierYearsOfExperience(StaffId staffId, LabCourierId entityId, YearsOfExperience yearsOfExperience) {
        this.staffId = staffId;
        this.entityId = entityId;
        this.yearsOfExperience = yearsOfExperience;
    }

    public StaffId getStaffId() {
        return staffId;
    }

    public LabCourierId getEntityId() {
        return entityId;
    }

    public YearsOfExperience getYearsOfExperience() {
        return yearsOfExperience;
    }
}
