package org.example.infrastructur.persistance;

import org.example.application.interfaces.context.BacklogDatabaseContext;
import org.example.application.interfaces.context.DepartmentDatabaseContext;
import org.example.application.interfaces.context.EmployeeDatabaseContext;
import org.example.application.interfaces.context.SprintDatabaseContext;
import org.example.database.backlog.BacklogDatabase;
import org.example.database.backlog.BacklogRecord;
import org.example.database.department.DepartmentDatabase;
import org.example.database.department.DepartmentRecord;
import org.example.database.employee.EmployeeDatabase;
import org.example.database.employee.EmployeeRecord;
import org.example.database.sprint.SprintDatabase;
import org.example.database.sprint.SprintRecord;
import org.example.domain.backlog.Backlog;
import org.example.domain.department.Department;
import org.example.domain.employee.Employee;
import org.example.domain.sprint.Sprint;
import org.example.infrastructur.persistance.configurations.BacklogConfiguration;
import org.example.infrastructur.persistance.configurations.DepartmentConfiguration;
import org.example.infrastructur.persistance.configurations.EmployeeConfiguration;
import org.example.infrastructur.persistance.configurations.SprintConfiguration;

import java.util.ArrayList;
import java.util.Collection;

public class DatabaseContext extends DbContext implements EmployeeDatabaseContext, BacklogDatabaseContext, DepartmentDatabaseContext, SprintDatabaseContext {
    public DatabaseContext(Database database) {
        super(database);
    }
    @Override
    public Collection<Employee> getAllEmployee(){
        Collection<Employee> employees = new ArrayList<>();
        for(EmployeeRecord record : ((EmployeeDatabase)database).getEmployeeTable().getRecords()){
            employees.add(new Employee(
                    record.getId(),
                    record.getName(),
                    record.getSurname(),
                    record.getMail(),
                    record.getSalary(),
                    record.getPassword(),
                    record.getAccess()
            ));
        }
        return employees;
    }
    @Override
    public Collection<Backlog> getAllBacklog(){
        Collection<Backlog> backlogs = new ArrayList<>();
        for(BacklogRecord backlog : ((BacklogDatabase)database).getBacklogTable().getRecords()){
            backlogs.add(new Backlog(
                    backlog.getId(),
                    backlog.getName(),
                    backlog.getDescription(),
                    backlog.getStartDate(),
                    backlog.getEndDate()
            ));
        }
        return backlogs;
    }

    @Override
    public Collection<Department> getAllDepartment() {
       Collection<Department> departments = new ArrayList<>();
       for(DepartmentRecord department: ((DepartmentDatabase)database).getDepartmentTable().getRecords()){
           departments.add(new Department(
                   department.getDepartmentId(),
                   department.getDepartmentName()
           ));
       }
       return departments;
    }

    @Override
    public Collection<Sprint> getAllSprint() {
        Collection<Sprint> sprints = new ArrayList<>();
        for(SprintRecord sprint: ((SprintDatabase)database).getSprintTable().getRecords()){
            sprints.add(new Sprint(
                    sprint.getId(),
                    sprint.getDescription(),
                    sprint.getPriority(),
                    sprint.getEndDate()
            ));
        }
        return sprints;
    }

    @Override
    protected void onModelBuilder(ModelBuilder builder) {
        builder.applyConfiguration(new EmployeeConfiguration());
        builder.applyConfiguration(new BacklogConfiguration());
        builder.applyConfiguration(new DepartmentConfiguration());
        builder.applyConfiguration(new SprintConfiguration());
    }



}
