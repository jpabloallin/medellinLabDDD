package com.sofkaU.medellinLabDDD.staff.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class YearsOfExperience implements ValueObject<Integer> {
    private final Integer value;

    public YearsOfExperience(Integer value) {
        this.value = Objects.requireNonNull(value);
        if (this.value <2) {
            throw new IllegalArgumentException("You must have 2 or more years of experience on the field");
        }
    }
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YearsOfExperience that = (YearsOfExperience) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
