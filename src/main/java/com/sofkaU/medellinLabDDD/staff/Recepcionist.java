package com.sofkaU.medellinLabDDD.staff;

import co.com.sofka.domain.generic.Entity;
import com.sofkaU.medellinLabDDD.lab.values.Name;
import com.sofkaU.medellinLabDDD.staff.values.RecepcionistId;
import com.sofkaU.medellinLabDDD.staff.values.YearsOfExperience;

public class Recepcionist extends Entity<RecepcionistId> {
    private final Name name;
    private final YearsOfExperience yearsOfExperience;

    public Recepcionist(RecepcionistId entityId, Name name, YearsOfExperience yearsOfExperience) {
        super(entityId);
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
    }

    public Name name() {
        return name;
    }

    public YearsOfExperience yearsOfExperience() {
        return yearsOfExperience;
    }
}
