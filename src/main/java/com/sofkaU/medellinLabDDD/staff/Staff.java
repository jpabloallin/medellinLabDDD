package com.sofkaU.medellinLabDDD.staff;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofkaU.medellinLabDDD.staff.events.StaffCreated;
import com.sofkaU.medellinLabDDD.staff.values.StaffId;
import com.sofkaU.medellinLabDDD.staff.values.WorkArea;

import java.util.Set;

public class Staff  extends AggregateEvent<StaffId> {
    protected WorkArea workArea;
    protected Set<LabCourier> labCouriers;
    protected Set<Cleaner> cleaners;
    protected Set<Recepcionist> recepcionists;
    public Staff(StaffId entityId, WorkArea workArea) {
        super(entityId);
        appendChange(new StaffCreated(workArea)).apply();
    }
}
