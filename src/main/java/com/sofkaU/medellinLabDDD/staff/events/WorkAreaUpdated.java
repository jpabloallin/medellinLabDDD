package com.sofkaU.medellinLabDDD.staff.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.medellinLabDDD.staff.values.WorkArea;

public class WorkAreaUpdated extends DomainEvent {
    private final WorkArea workArea;

    public WorkAreaUpdated(WorkArea workArea) {
        super("laboratory.staff.workareaupdated");
        this.workArea = workArea;
    }

    public WorkArea getWorkArea() {
        return workArea;
    }
}
