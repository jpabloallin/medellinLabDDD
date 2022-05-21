package com.sofkaU.medellinLabDDD.lab.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DeviceName implements ValueObject<String> {

    private final String value;

    public DeviceName(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("Device name can not be empty");
        }
    }
    public String value() {
        return value;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceName that = (DeviceName) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
