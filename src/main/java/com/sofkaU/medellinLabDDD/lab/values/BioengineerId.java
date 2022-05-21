package com.sofkaU.medellinLabDDD.lab.values;

import co.com.sofka.domain.generic.Identity;

public class BioengineerId extends Identity {
    public BioengineerId() {

    }
    private BioengineerId(String id) {
        super(id);
    }
    public static BioengineerId of(String id) {
        return new BioengineerId(id);
    }
}
