package com.sofkaU.medellinLabDDD.useCases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.medellinLabDDD.lab.commands.UpdateLabType;
import com.sofkaU.medellinLabDDD.lab.events.LabCreated;
import com.sofkaU.medellinLabDDD.lab.events.LabTypeUpdated;
import com.sofkaU.medellinLabDDD.lab.values.LabId;
import com.sofkaU.medellinLabDDD.lab.values.LabType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UpdateLabTypeUseCaseTest {

    private final String ROOT_ID = "Upt1";
    private UpdateLabTypeUseCase updateLabTypeUseCase;
    private DomainEventRepository repository;

    @BeforeEach
    public void setUp(){
        updateLabTypeUseCase= new UpdateLabTypeUseCase();
        repository = Mockito.mock(DomainEventRepository.class);
        updateLabTypeUseCase.addRepository(repository);
    }
    @Test
    void updateLabType(){
        //arrange
        var command = new UpdateLabType(LabId.of(ROOT_ID),new LabType("Immunology"));

        Mockito.when(repository.getEventsBy(ArgumentMatchers.any())).thenReturn(labTypeEventUpdated());

        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ROOT_ID)
                .syncExecutor(updateLabTypeUseCase,new RequestCommand<>(command))
                .orElseThrow();
        var events = response.getDomainEvents();

        //assert
        LabTypeUpdated updateLabTypeUseCase = (LabTypeUpdated) events.get(0);
        Assertions.assertEquals("laboratory.lab.labtypeupdated",updateLabTypeUseCase.type);
        Assertions.assertEquals("Immunology",updateLabTypeUseCase.getLabType().value());
    }
    private List<DomainEvent> labTypeEventUpdated() {
        return  List.of(new LabCreated(new LabType("Oncology")));
    }
}