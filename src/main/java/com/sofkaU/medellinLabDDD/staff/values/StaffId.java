package com.sofkaU.medellinLabDDD.staff.values;

import co.com.sofka.domain.generic.Identity;

public class StaffId extends Identity {
    public StaffId() {

    }
    private StaffId(String id) {
        super(id);
    }
    public static StaffId of(String id) {
        return new StaffId(id);
    }
}
