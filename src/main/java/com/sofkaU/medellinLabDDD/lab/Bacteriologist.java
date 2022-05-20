package com.sofkaU.medellinLabDDD.lab;

import co.com.sofka.domain.generic.Entity;
import com.sofkaU.medellinLabDDD.lab.values.BacteriologistId;
import com.sofkaU.medellinLabDDD.lab.values.Name;

import java.util.Objects;

public class Bacteriologist extends Entity<BacteriologistId> {
    private Name name;

    public Bacteriologist(BacteriologistId entityId, Name name) {
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
