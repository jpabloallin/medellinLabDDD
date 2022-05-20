package com.sofkaU.medellinLabDDD.lab;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofkaU.medellinLabDDD.lab.values.LabId;
import com.sofkaU.medellinLabDDD.lab.values.LabType;

public class Lab extends AggregateEvent<LabId> {

    public Lab(LabId entityId, LabType) {
        super(entityId);
    }
}
