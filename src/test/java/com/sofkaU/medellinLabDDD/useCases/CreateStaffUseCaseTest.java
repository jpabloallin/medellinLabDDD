package com.sofkaU.medellinLabDDD.useCases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofkaU.medellinLabDDD.staff.commands.CreateStaff;
import com.sofkaU.medellinLabDDD.staff.events.StaffCreated;
import com.sofkaU.medellinLabDDD.staff.values.StaffId;
import com.sofkaU.medellinLabDDD.staff.values.WorkArea;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateStaffUseCaseTest {

    @Test
    void createStaffWithAllTheParameters() {
        //Arrange
        var command = new CreateStaff(
                StaffId.of("XXX2"),
                new WorkArea("Cytology")
        );

        var useCase = new CreateStaffUseCase();
        //Act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()-> new IllegalArgumentException("Something went wrong when you tried to create the staff"))
                .getDomainEvents();

        //Assert
        var event = (StaffCreated)events.get(0);
        Assertions.assertEquals(command.getWorkArea().value(), event.getWorkArea().value());
    }
}