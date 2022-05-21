package com.sofkaU.medellinLabDDD.staff.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.medellinLabDDD.staff.values.CleanerId;
import com.sofkaU.medellinLabDDD.staff.values.StaffId;
import com.sofkaU.medellinLabDDD.staff.values.YearsOfExperience;

public class UpdateCleanerYearsOfExperience extends Command {
    private final StaffId staffId;
    private final CleanerId entityId;
    private final YearsOfExperience yearsOfExperience;

    public UpdateCleanerYearsOfExperience(StaffId staffId, CleanerId entityId, YearsOfExperience yearsOfExperience) {
        this.staffId = staffId;
        this.entityId = entityId;
        this.yearsOfExperience = yearsOfExperience;
    }

    public StaffId getStaffId() {
        return staffId;
    }

    public CleanerId getEntityId() {
        return entityId;
    }

    public YearsOfExperience getYearsOfExperience() {
        return yearsOfExperience;
    }
}
