package com.sofkaU.medellinLabDDD.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.medellinLabDDD.staff.Staff;
import com.sofkaU.medellinLabDDD.staff.commands.UpdateWorkArea;

public class UpdateWorkAreaUseCase extends UseCase<RequestCommand<UpdateWorkArea>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateWorkArea> updateWorkAreaRequestCommand){
        var command = updateWorkAreaRequestCommand.getCommand();
        var staff = Staff.from(command.getStaffId(),retrieveEvents(command.getStaffId().value()));
        staff.updateWorkArea(command.getWorkArea());

        emit().onResponse(new ResponseEvents(staff.getUncommittedChanges()));
    }
}
