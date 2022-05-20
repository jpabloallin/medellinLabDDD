package com.sofkaU.medellinLabDDD.lab;

import co.com.sofka.domain.generic.Entity;
import com.sofkaU.medellinLabDDD.lab.values.BioengineerId;
import com.sofkaU.medellinLabDDD.lab.values.Name;

import java.util.Objects;

public class Bioengineer extends Entity<BioengineerId> {
    private Name name;

    public Bioengineer(BioengineerId entityId, Name name) {
        super(entityId);
        this.name = name;
    }
    public void updateName(Name name) {
        this.name = Objects.requireNonNull(name);
    }
    public Name name() {
        return name;
    }
}
