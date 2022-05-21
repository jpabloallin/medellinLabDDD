package com.sofkaU.medellinLabDDD.useCases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkaU.medellinLabDDD.lab.events.DeviceAdded;
import com.sofkaU.medellinLabDDD.lab.events.LabCreated;
import com.sofkaU.medellinLabDDD.lab.values.LabType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class AddDeviceByLabCreatedUseCaseTest {
    private final String ROOT_ID = "NHSXXX";

    @Mock
    private DomainEventRepository repository;

    @Test
    void AddDeviceByLab() {
        var event = new LabCreated(
               new LabType("Rooftop")
        );
        event.setAggregateRootId(ROOT_ID);
        var useCase = new AddDeviceByLabCreatedUseCase();

        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(
                event
        ));
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOT_ID)
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var eventTrigger = (DeviceAdded)events.get(0);
        Assertions.assertEquals("Voltmeter", eventTrigger.getDeviceName().value());
        Assertions.assertEquals("VMX123", eventTrigger.getModel().value());
        Assertions.assertEquals(6, eventTrigger.getLifeSpan().value());
        Mockito.verify(repository).getEventsBy(ROOT_ID);
    }
}