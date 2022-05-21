package com.sofkaU.medellinLabDDD.staff.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.medellinLabDDD.staff.values.Name;
import com.sofkaU.medellinLabDDD.staff.values.RecepcionistId;
import com.sofkaU.medellinLabDDD.staff.values.StaffId;
import com.sofkaU.medellinLabDDD.staff.values.YearsOfExperience;

public class AddRecepcionist extends Command {
    private final StaffId staffId;
    private final RecepcionistId entityId;
    private final Name name;
    private final YearsOfExperience yearsOfExperience;

    public AddRecepcionist(StaffId staffId, RecepcionistId entityId, Name name, YearsOfExperience yearsOfExperience) {
        this.staffId = staffId;
        this.entityId = entityId;
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
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

    public YearsOfExperience getYearsOfExperience() {
        return yearsOfExperience;
    }
}
