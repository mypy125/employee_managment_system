package org.example.application.interfaces;

import org.example.domain.employee.Employee;

import java.util.Collection;

public interface EmployeePresenter {
    void printAll(Collection<Employee> employee);
}
