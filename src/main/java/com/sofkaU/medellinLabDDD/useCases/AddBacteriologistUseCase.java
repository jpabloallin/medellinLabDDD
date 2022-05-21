package com.sofkaU.medellinLabDDD.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.medellinLabDDD.lab.Lab;
import com.sofkaU.medellinLabDDD.lab.commands.AddBacteriologist;

public class AddBacteriologistUseCase extends UseCase<RequestCommand<AddBacteriologist>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddBacteriologist> addBacteriologistRequestCommand) {
        var command = addBacteriologistRequestCommand.getCommand();
        var lab = Lab.from(command.getLabId(), retrieveEvents(command.getLabId().value()));
        lab.addBacteriologist(command.getEntityId(), command.getName());

        emit().onResponse(new ResponseEvents(lab.getUncommittedChanges()));
    }
}
