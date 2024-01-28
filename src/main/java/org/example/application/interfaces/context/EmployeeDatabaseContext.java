package org.example.application.interfaces.context;

import org.example.domain.employee.Employee;

import java.util.Collection;

public interface EmployeeDatabaseContext {
    Collection<Employee> getAllEmployee();
    boolean saveChanges();
}
