package com.sofkaU.medellinLabDDD.staff.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.medellinLabDDD.staff.values.RecepcionistId;
import com.sofkaU.medellinLabDDD.staff.values.StaffId;
import com.sofkaU.medellinLabDDD.staff.values.YearsOfExperience;

public class UpdateRecepcionistYearsOfExperience extends Command {
    private final StaffId staffId;
    private final RecepcionistId entityId;
    private final YearsOfExperience yearsOfExperience;

    public UpdateRecepcionistYearsOfExperience(StaffId staffId, RecepcionistId entityId, YearsOfExperience yearsOfExperience) {
        this.staffId = staffId;
        this.entityId = entityId;
        this.yearsOfExperience = yearsOfExperience;
    }

    public StaffId getStaffId() {
        return staffId;
    }

    public RecepcionistId getEntityId() {
        return entityId;
    }

    public YearsOfExperience getYearsOfExperience() {
        return yearsOfExperience;
    }
}
