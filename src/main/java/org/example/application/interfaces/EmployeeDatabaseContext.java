package org.example.application.interfaces;

import org.example.domain.employee.Employee;

import java.util.Collection;

public interface EmployeeDatabaseContext {
    Collection<Employee> getAll();
    boolean saveChanges();
}
