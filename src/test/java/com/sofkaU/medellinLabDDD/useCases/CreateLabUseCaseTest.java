package com.sofkaU.medellinLabDDD.useCases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofkaU.medellinLabDDD.lab.commands.CreateLab;
import com.sofkaU.medellinLabDDD.lab.events.LabCreated;
import com.sofkaU.medellinLabDDD.lab.values.LabId;
import com.sofkaU.medellinLabDDD.lab.values.LabType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateLabUseCaseTest {

    @Test
    void createLabWithAllTheParameters() {
        //Arrange
        var command = new CreateLab(
                LabId.of("XXX1"),
                new LabType("Hematology")
        );

        var useCase = new CreateLabUseCase();
        //Act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()-> new IllegalArgumentException("Something went wrong when you tried to create the lab"))
                .getDomainEvents();

        //Assert
        var event = (LabCreated)events.get(0);
        Assertions.assertEquals(command.getLabType().value(), event.getLabType().value());
    }
}