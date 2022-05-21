package com.sofkaU.medellinLabDDD.staff.values;

import co.com.sofka.domain.generic.Identity;

public class CleanerId extends Identity {
    public CleanerId() {

    }
    private CleanerId(String id) {
        super(id);
    }
    public static CleanerId of(String id) {
        return new CleanerId(id);
    }
}
