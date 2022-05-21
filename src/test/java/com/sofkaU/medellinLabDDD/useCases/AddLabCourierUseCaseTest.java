package com.sofkaU.medellinLabDDD.useCases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkaU.medellinLabDDD.staff.commands.AddLabCourier;
import com.sofkaU.medellinLabDDD.staff.events.LabCourierAdded;
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
class AddLabCourierUseCaseTest {
    private final String ROOT_ID = "LCXXX";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addLabCourier() {
        var command = new AddLabCourier(StaffId.of(ROOT_ID), LabCourierId.of("lc5"), new Name("Fernando Perez"),
                new YearsOfExperience(8));
        var useCase = new AddLabCourierUseCase();

        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(
                new StaffCreated(
                        new WorkArea("America")
                )
        ));

        useCase.addRepository(repository);
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOT_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()-> new IllegalStateException("Something went wrong while creating a lab courier"))
                .getDomainEvents();

        var event = (LabCourierAdded)events.get(0);
        Assertions.assertEquals(command.getName().value(), event.getName().value());
        Assertions.assertEquals(command.getYearsOfExperience().value(), event.getYearsOfExperience().value());
        Mockito.verify(repository).getEventsBy(ROOT_ID);
    }
}