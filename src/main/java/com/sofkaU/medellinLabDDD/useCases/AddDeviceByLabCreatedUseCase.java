package com.sofkaU.medellinLabDDD.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkaU.medellinLabDDD.lab.Lab;
import com.sofkaU.medellinLabDDD.lab.events.LabCreated;
import com.sofkaU.medellinLabDDD.lab.values.*;

public class AddDeviceByLabCreatedUseCase extends UseCase<TriggeredEvent<LabCreated>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<LabCreated> labCreatedTriggeredEvent) {
        var event = labCreatedTriggeredEvent.getDomainEvent();
        var lab = Lab.from(LabId.of(event.aggregateRootId()), this.retrieveEvents());
        lab.addDevice(new DeviceId(), new DeviceName("Voltmeter"), new Model("VMX123"), new LifeSpan(6));
        emit().onResponse(new ResponseEvents(lab.getUncommittedChanges()));
    }
}
