package com.sofkaU.medellinLabDDD.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.medellinLabDDD.lab.Lab;
import com.sofkaU.medellinLabDDD.lab.commands.AddDevice;

public class AddDeviceUseCase extends UseCase<RequestCommand<AddDevice>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddDevice> addDeviceRequestCommand) {
        var command = addDeviceRequestCommand.getCommand();
        var lab = Lab.from(command.getLabId(), retrieveEvents(command.getLabId().value()));
        lab.addDevice(command.getDeviceId(), command.getDeviceName(), command.getModel(), command.getLifeSpan());

        emit().onResponse(new ResponseEvents(lab.getUncommittedChanges()));
    }
}
