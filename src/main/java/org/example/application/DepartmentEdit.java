package org.example.application;

import org.example.application.interfaces.DepartmentEditor;
import org.example.application.interfaces.context.DepartmentDatabaseContext;
import org.example.domain.department.Department;

import java.util.Collection;
import java.util.Optional;

public class DepartmentEdit implements DepartmentEditor {
    private DepartmentDatabaseContext databaseContext;

    public DepartmentEdit(DepartmentDatabaseContext databaseContext) {
        this.databaseContext = databaseContext;
    }

    @Override
    public boolean add(Department item) {
        databaseContext.getAllDepartment().add(item);
        return databaseContext.saveChanges();
    }

    @Override
    public boolean edit(Department item) {
        if(item == null)
            return false;
        Optional<Department> departments = getById(item.getId());
        if(departments.isEmpty())
            return false;
        departments.get().setDepartmentId(item.getId());
        departments.get().setDepartmentName(item.getDepartmentName());
       return databaseContext.saveChanges();
    }

    @Override
    public boolean remove(Department item) {
        databaseContext.getAllDepartment().remove(item);
        return databaseContext.saveChanges();
    }

    @Override
    public Optional<Department> getById(Integer integer) {
        return databaseContext.getAllDepartment().stream().filter(p -> p.getId() == integer).findFirst();
    }

    @Override
    public Collection<Department> getAll() {
        return databaseContext.getAllDepartment();
    }
}
