package com.sofkaU.medellinLabDDD.useCases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkaU.medellinLabDDD.lab.commands.AddBacteriologist;
import com.sofkaU.medellinLabDDD.lab.events.BacteriologistAdded;
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
class AddBacteriologistUseCaseTest {

    private final String ROOT_ID = "BXXX";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addBacteriologist() {
        var command = new AddBacteriologist(LabId.of(ROOT_ID), BacteriologistId.of("bac123"), new Name("Juan Pablo"));
        var useCase = new AddBacteriologistUseCase();

        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(
                new LabCreated(
                        new LabType("Chemistry")
                )
        ));

        useCase.addRepository(repository);
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOT_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()-> new IllegalStateException("Something went wrong while creating a bacteriologist"))
                .getDomainEvents();

        var event = (BacteriologistAdded)events.get(0);
        Assertions.assertEquals(command.getName().value(), event.getName().value());
        Mockito.verify(repository).getEventsBy(ROOT_ID);
    }
}