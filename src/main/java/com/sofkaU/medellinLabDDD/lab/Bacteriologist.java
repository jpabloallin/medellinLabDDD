package com.sofkaU.medellinLabDDD.lab;

import co.com.sofka.domain.generic.Entity;
import com.sofkaU.medellinLabDDD.lab.values.BacteriologistId;
import com.sofkaU.medellinLabDDD.lab.values.Name;

public class Bacteriologist extends Entity<BacteriologistId> {
    private final Name name;

    public Bacteriologist(BacteriologistId entityId, Name name) {
        super(entityId);
        this.name = name;
    }

    public Name name() {
        return name;
    }
}
