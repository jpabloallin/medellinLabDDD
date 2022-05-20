package com.sofkaU.medellinLabDDD.staff.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.medellinLabDDD.staff.values.WorkArea;

public class StaffCreated extends DomainEvent {
    private final WorkArea workArea;

    public StaffCreated(WorkArea workArea) {
        super("laboratory.staff.staffcreated");
        this.workArea = workArea;
    }

    public WorkArea getWorkArea() {
        return workArea;
    }
}
