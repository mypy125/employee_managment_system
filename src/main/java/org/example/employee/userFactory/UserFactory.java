package org.example.employee.userFactory;

import org.example.employee.AdminUser;
import org.example.employee.BaseEmployee;
import org.example.employee.EmployeeUser;
import org.example.employee.userFactory.CreatorEmployee;
import org.example.employee.userFactory.EmployeeType;

public class UserFactory extends CreatorEmployee {
    @Override
    protected BaseEmployee creatorEmployee(EmployeeType type) {
        return switch (type){
            case BASE -> new BaseEmployee();
            case USER -> new EmployeeUser();
            case ADMIN -> new AdminUser();
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }
}
