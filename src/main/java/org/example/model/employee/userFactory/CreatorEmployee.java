package org.example.model.employee.userFactory;

import org.example.model.employee.BaseEmployee;
import org.example.model.EmployeeType;

public abstract class CreatorEmployee{
    public BaseEmployee getEmployee(EmployeeType type){
        return creatorEmployee(type);


    }

    protected abstract BaseEmployee creatorEmployee(EmployeeType type);

}
