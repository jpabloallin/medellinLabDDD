package com.sofkaU.medellinLabDDD.staff.values;

import co.com.sofka.domain.generic.Identity;

public class LabCourierId extends Identity {
    public LabCourierId() {

    }
    private LabCourierId(String id) {
        super(id);
    }
    public static LabCourierId of(String id) {
        return new LabCourierId(id);
    }
}
