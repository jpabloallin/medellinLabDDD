package com.sofkaU.medellinLabDDD.staff;

import co.com.sofka.domain.generic.Entity;
import com.sofkaU.medellinLabDDD.staff.values.Name;
import com.sofkaU.medellinLabDDD.staff.values.LabCourierId;
import com.sofkaU.medellinLabDDD.staff.values.YearsOfExperience;

import java.util.Objects;

public class LabCourier extends Entity<LabCourierId> {
    private Name name;
    private YearsOfExperience yearsOfExperience;

    public LabCourier(LabCourierId entityId, Name name, YearsOfExperience yearsOfExperience) {
        super(entityId);
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
    }
    public void updateName(Name name) {
        this.name = Objects.requireNonNull(name);
    }
    public void updateYearsOfExperience(YearsOfExperience yearsOfExperience) {
        this.yearsOfExperience = Objects.requireNonNull(yearsOfExperience);
    }
    public Name name() {
        return name;
    }

    public YearsOfExperience yearsOfExperience() {
        return yearsOfExperience;
    }
}
