package com.sofkaU.medellinLabDDD.staff;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofkaU.medellinLabDDD.staff.values.StaffId;

public class Staff  extends AggregateEvent<StaffId> {
    public Staff(StaffId entityId) {
        super(entityId);
    }
}
