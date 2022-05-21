package com.sofkaU.medellinLabDDD.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.medellinLabDDD.staff.Staff;
import com.sofkaU.medellinLabDDD.staff.commands.AddRecepcionist;

public class AddReceptionistUseCase extends UseCase<RequestCommand<AddRecepcionist>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddRecepcionist> addRecepcionistRequestCommand) {
        var command = addRecepcionistRequestCommand.getCommand();
        var staff = Staff.from(command.getStaffId(), retrieveEvents(command.getStaffId().value()));
        staff.addRecepcionist(command.getEntityId(), command.getName(), command.getYearsOfExperience());

        emit().onResponse(new ResponseEvents(staff.getUncommittedChanges()));
    }
}
