package org.example.employee.userFactory;

import org.example.employee.BaseEmployee;
import org.example.employee.userFactory.EmployeeType;

public abstract class CreatorEmployee{
    public BaseEmployee getEmployee(EmployeeType type){
        return creatorEmployee(type);


    }

    protected abstract BaseEmployee creatorEmployee(EmployeeType type);

}
