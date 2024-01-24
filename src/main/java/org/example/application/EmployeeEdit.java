package org.example.application;

import org.example.application.interfaces.EmployeeEditor;
import org.example.domain.employee.Employee;

import java.util.Collection;
import java.util.Optional;

public class EmployeeEdit implements EmployeeEditor {
    @Override
    public boolean add(Employee item) {
        return false;
    }

    @Override
    public boolean edit(Employee item) {
        return false;
    }

    @Override
    public boolean remove(Employee item) {
        return false;
    }

    @Override
    public Optional<Employee> getById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Collection<Employee> getAll() {
        return null;
    }
}
