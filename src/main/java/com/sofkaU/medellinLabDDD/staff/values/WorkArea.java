package com.sofkaU.medellinLabDDD.staff.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class WorkArea implements ValueObject<String> {
    private final String value;

    public WorkArea(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("Work area can not be empty");
        }
    }
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkArea workArea = (WorkArea) o;
        return Objects.equals(value, workArea.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
