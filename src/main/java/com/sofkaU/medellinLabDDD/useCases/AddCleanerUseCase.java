package com.sofkaU.medellinLabDDD.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.medellinLabDDD.staff.Staff;
import com.sofkaU.medellinLabDDD.staff.commands.AddCleaner;

public class AddCleanerUseCase extends UseCase<RequestCommand<AddCleaner>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddCleaner> addCleanerRequestCommand) {
        var command = addCleanerRequestCommand.getCommand();
        var staff = Staff.from(command.getStaffId(), retrieveEvents(command.getStaffId().value()));
        staff.addCleaner(command.getEntityId(), command.getName(), command.getYearsOfExperience());

        emit().onResponse(new ResponseEvents(staff.getUncommittedChanges()));
    }
}
