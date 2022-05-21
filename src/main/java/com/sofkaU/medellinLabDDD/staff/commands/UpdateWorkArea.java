package com.sofkaU.medellinLabDDD.staff.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.medellinLabDDD.staff.values.StaffId;
import com.sofkaU.medellinLabDDD.staff.values.WorkArea;

public class UpdateWorkArea extends Command {
    private final StaffId staffId;
    private final WorkArea workArea;

    public UpdateWorkArea(StaffId staffId, WorkArea workArea) {
        this.staffId = staffId;
        this.workArea = workArea;
    }

    public StaffId getStaffId() {
        return staffId;
    }

    public WorkArea getWorkArea() {
        return workArea;
    }
}
