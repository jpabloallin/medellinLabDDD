package com.sofkaU.medellinLabDDD.useCases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkaU.medellinLabDDD.staff.commands.AddRecepcionist;
import com.sofkaU.medellinLabDDD.staff.events.RecepcionistAdded;
import com.sofkaU.medellinLabDDD.staff.events.StaffCreated;
import com.sofkaU.medellinLabDDD.staff.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AddReceptionistUseCaseTest {
    private final String ROOT_ID = "RXXX";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addReceptionist() {
        var command = new AddRecepcionist(StaffId.of(ROOT_ID), RecepcionistId.of("r24"), new Name("Fernando Perez"),
                new YearsOfExperience(12));
        var useCase = new AddReceptionistUseCase();

        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(
                new StaffCreated(
                        new WorkArea("Reception")
                )
        ));

        useCase.addRepository(repository);
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOT_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()-> new IllegalStateException("Something went wrong while creating a receptionist"))
                .getDomainEvents();

        var event = (RecepcionistAdded)events.get(0);
        Assertions.assertEquals(command.getName().value(), event.getName().value());
        Assertions.assertEquals(command.getYearsOfExperience().value(), event.getYearsOfExperience().value());
        Mockito.verify(repository).getEventsBy(ROOT_ID);
    }
}