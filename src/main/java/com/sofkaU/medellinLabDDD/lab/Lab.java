package com.sofkaU.medellinLabDDD.lab;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofkaU.medellinLabDDD.lab.events.LabCreated;
import com.sofkaU.medellinLabDDD.lab.values.LabId;
import com.sofkaU.medellinLabDDD.lab.values.LabType;

import java.util.Set;

public class Lab extends AggregateEvent<LabId> {

    protected LabType LabType;
    protected Set<Device> devices;
    protected Set<Bacteriologist> bacteriologists;
    protected Set<Bioengineer> bioengineers;
    public Lab(LabId entityId, LabType labType) {
        super(entityId);
        appendChange(new LabCreated(labType)).apply();
    }
}
