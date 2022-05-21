package com.sofkaU.medellinLabDDD.useCases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.medellinLabDDD.staff.commands.UpdateWorkArea;
import com.sofkaU.medellinLabDDD.staff.events.WorkAreaUpdated;
import com.sofkaU.medellinLabDDD.staff.values.StaffId;
import com.sofkaU.medellinLabDDD.staff.values.WorkArea;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UpdateWorkAreaUseCaseTest {
    private final String ROOT_ID = "UptWA1";
    private UpdateWorkAreaUseCase updateWorkAreaUseCase;
    private DomainEventRepository repository;

    @BeforeEach
    public void setUp(){
        updateWorkAreaUseCase= new UpdateWorkAreaUseCase();
        repository = Mockito.mock(DomainEventRepository.class);
        updateWorkAreaUseCase.addRepository(repository);
    }
    @Test
    void updateLabType(){
        //arrange
        var command = new UpdateWorkArea(StaffId.of(ROOT_ID),new WorkArea("Sampling"));

        Mockito.when(repository.getEventsBy(ArgumentMatchers.any())).thenReturn(workAreaEventUpdated());

        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ROOT_ID)
                .syncExecutor(updateWorkAreaUseCase,new RequestCommand<>(command))
                .orElseThrow();
        var events = response.getDomainEvents();

        //assert
        WorkAreaUpdated updateWorkAreaUseCase = (WorkAreaUpdated) events.get(0);
        Assertions.assertEquals("laboratory.staff.workareaupdated",updateWorkAreaUseCase.type);
        Assertions.assertEquals("Sampling",updateWorkAreaUseCase.getWorkArea().value());
    }
    private List<DomainEvent> workAreaEventUpdated() {
        return  List.of(new WorkAreaUpdated(new WorkArea("Warehouse")));
    }
}