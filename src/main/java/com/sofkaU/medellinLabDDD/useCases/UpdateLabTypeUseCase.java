package com.sofkaU.medellinLabDDD.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.medellinLabDDD.lab.Lab;
import com.sofkaU.medellinLabDDD.lab.commands.UpdateLabType;

public class UpdateLabTypeUseCase extends UseCase<RequestCommand<UpdateLabType>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateLabType> updateLabTypeRequestCommand){
        var command = updateLabTypeRequestCommand.getCommand();
        var lab = Lab.from(command.getLabId(),retrieveEvents(command.getLabId().value()));
        lab.updateLabType(command.getLabType());

        emit().onResponse(new ResponseEvents(lab.getUncommittedChanges()));
    }
}
