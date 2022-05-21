package com.sofkaU.medellinLabDDD.lab.values;

import co.com.sofka.domain.generic.Identity;

public class BacteriologistId extends Identity {
    public BacteriologistId() {

    }
    private BacteriologistId(String id) {
        super(id);
    }
    public static BacteriologistId of(String id) {
        return new BacteriologistId(id);
    }
}
