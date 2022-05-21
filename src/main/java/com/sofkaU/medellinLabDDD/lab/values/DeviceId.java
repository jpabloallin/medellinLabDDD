package com.sofkaU.medellinLabDDD.lab.values;

import co.com.sofka.domain.generic.Identity;

public class DeviceId extends Identity {
    public DeviceId() {

    }
    private DeviceId(String id) {
        super(id);
    }
    public static DeviceId of(String id) {
        return new DeviceId(id);
    }
}
