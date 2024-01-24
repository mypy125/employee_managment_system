package org.example.application;

import org.example.application.interfaces.DepartmentEditor;
import org.example.domain.department.Department;

import java.util.Collection;
import java.util.Optional;

public class DepartmentEdit implements DepartmentEditor {
    @Override
    public boolean add(Department item) {
        return false;
    }

    @Override
    public boolean edit(Department item) {
        return false;
    }

    @Override
    public boolean remove(Department item) {
        return false;
    }

    @Override
    public Optional<Department> getById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Collection<Department> getAll() {
        return null;
    }
}
