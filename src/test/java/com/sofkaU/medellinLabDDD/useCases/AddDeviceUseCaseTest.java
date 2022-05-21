package com.sofkaU.medellinLabDDD.useCases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkaU.medellinLabDDD.lab.commands.AddDevice;
import com.sofkaU.medellinLabDDD.lab.events.DeviceAdded;
import com.sofkaU.medellinLabDDD.lab.events.LabCreated;
import com.sofkaU.medellinLabDDD.lab.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AddDeviceUseCaseTest {
    private final String ROOT_ID = "DXXX";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addDevice() {
        var command = new AddDevice(LabId.of(ROOT_ID), DeviceId.of("mic123"), new DeviceName("Microscopio"),
                new Model("MCOlympic"), new LifeSpan(10));
        var useCase = new AddDeviceUseCase();

        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(
                new LabCreated(
                        new LabType("Hematology")
                )
        ));

        useCase.addRepository(repository);
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOT_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()-> new IllegalStateException("Something went wrong while creating a device"))
                .getDomainEvents();

        var event = (DeviceAdded)events.get(0);
        Assertions.assertEquals(command.getDeviceName().value(), event.getDeviceName().value());
        Assertions.assertEquals(command.getModel().value(), event.getModel().value());
        Assertions.assertEquals(command.getLifeSpan().value(), event.getLifeSpan().value());
        Mockito.verify(repository).getEventsBy(ROOT_ID);
    }
}