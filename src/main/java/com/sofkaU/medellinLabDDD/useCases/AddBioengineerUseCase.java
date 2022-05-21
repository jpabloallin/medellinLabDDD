package com.sofkaU.medellinLabDDD.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.medellinLabDDD.lab.Lab;
import com.sofkaU.medellinLabDDD.lab.commands.AddBioengineer;

public class AddBioengineerUseCase extends UseCase<RequestCommand<AddBioengineer>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddBioengineer> addAddBioengineerRequestCommand) {
        var command = addAddBioengineerRequestCommand.getCommand();
        var lab = Lab.from(command.getLabId(), retrieveEvents(command.getLabId().value()));
        lab.addBioengineer(command.getEntityId(), command.getName());

        emit().onResponse(new ResponseEvents(lab.getUncommittedChanges()));
    }
}
