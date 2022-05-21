package com.sofkaU.medellinLabDDD.lab.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class LabType implements ValueObject<String> {
    private final String value;

    public LabType(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("Lab type can not be empty");
        }
        if (this.value.length() <=6) {
            throw new IllegalArgumentException("Lab type must have more than 6 characters");
        }
    }
    public String value() {
        return value;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LabType that = (LabType) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
