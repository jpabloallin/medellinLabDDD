package com.sofkaU.medellinLabDDD.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.medellinLabDDD.lab.Lab;
import com.sofkaU.medellinLabDDD.lab.commands.CreateLab;

public class CreateLabUseCase extends UseCase<RequestCommand<CreateLab>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateLab> createLabRequestCommand) {
        var command = createLabRequestCommand.getCommand();
        var lab = new Lab(
                command.getEntityId(),
                command.getLabType()
        );
        emit().onResponse(new ResponseEvents(lab.getUncommittedChanges()));
    }
}
