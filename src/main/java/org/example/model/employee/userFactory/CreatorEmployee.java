package org.example.model.employee.userFactory;

import org.example.model.employee.EntityEmployee;
import org.example.model.EmployeeType;

public abstract class CreatorEmployee{
    public EntityEmployee getEmployee(EmployeeType type){
        return creatorEmployee(type);


    }

    protected abstract EntityEmployee creatorEmployee(EmployeeType type);

}
