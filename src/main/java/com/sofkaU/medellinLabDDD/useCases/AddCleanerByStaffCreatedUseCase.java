package com.sofkaU.medellinLabDDD.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkaU.medellinLabDDD.lab.values.*;
import com.sofkaU.medellinLabDDD.staff.Staff;
import com.sofkaU.medellinLabDDD.staff.events.StaffCreated;
import com.sofkaU.medellinLabDDD.staff.values.CleanerId;
import com.sofkaU.medellinLabDDD.staff.values.Name;
import com.sofkaU.medellinLabDDD.staff.values.StaffId;
import com.sofkaU.medellinLabDDD.staff.values.YearsOfExperience;

public class AddCleanerByStaffCreatedUseCase extends UseCase<TriggeredEvent<StaffCreated>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<StaffCreated> staffCreatedTriggeredEvent) {
        var event = staffCreatedTriggeredEvent.getDomainEvent();
        var staff = Staff.from(StaffId.of(event.aggregateRootId()), this.retrieveEvents());
        staff.addCleaner(new CleanerId(), new Name("Jose Cano"), new YearsOfExperience(9));
        emit().onResponse(new ResponseEvents(staff.getUncommittedChanges()));
    }
}
