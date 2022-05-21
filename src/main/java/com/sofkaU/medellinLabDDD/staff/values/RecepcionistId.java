package com.sofkaU.medellinLabDDD.staff.values;

import co.com.sofka.domain.generic.Identity;

public class RecepcionistId extends Identity {
    public RecepcionistId() {

    }
    private RecepcionistId(String id) {
        super(id);
    }
    public static RecepcionistId of(String id) {
        return new RecepcionistId(id);
    }
}
