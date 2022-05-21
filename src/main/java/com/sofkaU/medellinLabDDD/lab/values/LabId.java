package com.sofkaU.medellinLabDDD.lab.values;

import co.com.sofka.domain.generic.Identity;

public class LabId extends Identity {
    public LabId() {

    }
    private LabId(String id) {
        super(id);
    }
    public static LabId of(String id) {
        return new LabId(id);
    }
}
