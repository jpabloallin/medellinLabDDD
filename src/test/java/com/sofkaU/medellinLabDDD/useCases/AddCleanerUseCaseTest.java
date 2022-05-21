package com.sofkaU.medellinLabDDD.useCases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkaU.medellinLabDDD.staff.commands.AddCleaner;
import com.sofkaU.medellinLabDDD.staff.events.CleanerAdded;
import com.sofkaU.medellinLabDDD.staff.events.StaffCreated;
import com.sofkaU.medellinLabDDD.staff.values.*;
import com.sofkaU.medellinLabDDD.staff.values.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AddCleanerUseCaseTest {

    private final String ROOT_ID = "CXXX";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addCleaner() {
        var command = new AddCleaner(StaffId.of(ROOT_ID), CleanerId.of("cle2"), new Name("Fernando Perez"),
                new YearsOfExperience(6));
        var useCase = new AddCleanerUseCase();

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
                .orElseThrow(()-> new IllegalStateException("Something went wrong while creating a cleaner"))
                .getDomainEvents();

        var event = (CleanerAdded)events.get(0);
        Assertions.assertEquals(command.getName().value(), event.getName().value());
        Assertions.assertEquals(command.getYearsOfExperience().value(), event.getYearsOfExperience().value());
        Mockito.verify(repository).getEventsBy(ROOT_ID);
    }
}