package com.sofkaU.medellinLabDDD.lab.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class LifeSpan implements ValueObject<Integer> {
    private final Integer value;

    public LifeSpan(Integer value) {
        this.value = Objects.requireNonNull(value);
        if (this.value < 5) {
            throw new IllegalArgumentException("5 or more years of life span are required");
        }
    }
    public Integer value() {
        return value;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LifeSpan that = (LifeSpan) o;
        return Objects.equals(value, that.value);
    }
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
