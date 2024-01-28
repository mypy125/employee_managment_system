package org.example.application.interfaces.context;

import org.example.domain.backlog.Backlog;
import org.example.domain.department.Department;

import java.util.Collection;

public interface DepartmentDatabaseContext {
    Collection<Department> getAllDepartment();
    boolean saveChanges();
}
