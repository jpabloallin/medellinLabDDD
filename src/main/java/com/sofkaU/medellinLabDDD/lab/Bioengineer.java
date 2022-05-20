package com.sofkaU.medellinLabDDD.lab;

import co.com.sofka.domain.generic.Entity;
import com.sofkaU.medellinLabDDD.lab.values.BioengineerId;
import com.sofkaU.medellinLabDDD.lab.values.Name;

public class Bioengineer extends Entity<BioengineerId> {
    private final Name name;

    public Bioengineer(BioengineerId entityId, Name name) {
        super(entityId);
        this.name = name;
    }
    public Name name() {
        return name;
    }
}
