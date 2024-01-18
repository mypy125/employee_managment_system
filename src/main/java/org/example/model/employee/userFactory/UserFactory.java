package org.example.model.employee.userFactory;

import org.example.model.EmployeeType;
import org.example.model.employee.EmployeeUser;
import org.example.model.employee.AdminUser;
import org.example.model.employee.EntityEmployee;

public class UserFactory extends CreatorEmployee{
    @Override
    protected EntityEmployee creatorEmployee(EmployeeType type) {
        return switch (type){
            case BASE -> new EntityEmployee();
            case USER -> new EmployeeUser();
            case ADMIN -> new AdminUser();
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }
}
