package org.example.application.interfaces;

import org.example.domain.employee.Employee;

public interface EmployeeEditor extends Editor<Employee,Integer> {
    void printAll();
}
