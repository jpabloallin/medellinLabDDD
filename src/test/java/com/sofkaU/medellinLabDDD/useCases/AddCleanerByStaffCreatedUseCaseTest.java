package com.sofkaU.medellinLabDDD.useCases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkaU.medellinLabDDD.lab.events.DeviceAdded;
import com.sofkaU.medellinLabDDD.lab.events.LabCreated;
import com.sofkaU.medellinLabDDD.lab.values.LabType;
import com.sofkaU.medellinLabDDD.staff.events.CleanerAdded;
import com.sofkaU.medellinLabDDD.staff.events.StaffCreated;
import com.sofkaU.medellinLabDDD.staff.values.WorkArea;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AddCleanerByStaffCreatedUseCaseTest {
    private final String ROOT_ID = "NCBYSXXX";

    @Mock
    private DomainEventRepository repository;

    @Test
    void AddCleanerByStaff() {
        var event = new StaffCreated(
                new WorkArea("Administration")
        );
        event.setAggregateRootId(ROOT_ID);
        var useCase = new AddCleanerByStaffCreatedUseCase();

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

        var eventTrigger = (CleanerAdded)events.get(0);
        Assertions.assertEquals("Jose Cano", eventTrigger.getName().value());
        Assertions.assertEquals(9, eventTrigger.getYearsOfExperience().value());
        Mockito.verify(repository).getEventsBy(ROOT_ID);
    }
}