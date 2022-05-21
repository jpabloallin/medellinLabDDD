package com.sofkaU.medellinLabDDD.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.medellinLabDDD.staff.Staff;
import com.sofkaU.medellinLabDDD.staff.commands.AddCleaner;
import com.sofkaU.medellinLabDDD.staff.commands.AddLabCourier;

public class AddLabCourierUseCase extends UseCase<RequestCommand<AddLabCourier>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddLabCourier> addAddLabCourierRequestCommand) {
        var command = addAddLabCourierRequestCommand.getCommand();
        var staff = Staff.from(command.getStaffId(), retrieveEvents(command.getStaffId().value()));
        staff.addLabCourier(command.getEntityId(), command.getName(), command.getYearsOfExperience());

        emit().onResponse(new ResponseEvents(staff.getUncommittedChanges()));
    }
}
