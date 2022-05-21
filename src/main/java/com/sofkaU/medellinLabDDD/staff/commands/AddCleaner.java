package com.sofkaU.medellinLabDDD.staff.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.medellinLabDDD.staff.values.CleanerId;
import com.sofkaU.medellinLabDDD.staff.values.Name;
import com.sofkaU.medellinLabDDD.staff.values.StaffId;
import com.sofkaU.medellinLabDDD.staff.values.YearsOfExperience;

public class AddCleaner extends Command {
    private final StaffId staffId;
    private final CleanerId entityId;
    private final Name name;
    private final YearsOfExperience yearsOfExperience;

    public AddCleaner(StaffId staffId, CleanerId entityId, Name name, YearsOfExperience yearsOfExperience) {
        this.staffId = staffId;
        this.entityId = entityId;
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
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

    public YearsOfExperience getYearsOfExperience() {
        return yearsOfExperience;
    }
}
