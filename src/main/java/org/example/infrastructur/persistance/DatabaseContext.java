package org.example.infrastructur.persistance;

import org.example.application.interfaces.context.BacklogDatabaseContext;
import org.example.application.interfaces.context.EmployeeDatabaseContext;
import org.example.database.backlog.BacklogDatabase;
import org.example.database.backlog.BacklogRecord;
import org.example.database.employee.EmployeeDatabase;
import org.example.database.employee.EmployeeRecord;
import org.example.domain.backlog.Backlog;
import org.example.domain.employee.Employee;
import org.example.infrastructur.persistance.configurations.BacklogConfiguration;
import org.example.infrastructur.persistance.configurations.EmployeeConfiguration;

import java.util.ArrayList;
import java.util.Collection;

public class DatabaseContext extends DbContext implements EmployeeDatabaseContext, BacklogDatabaseContext {
    public DatabaseContext(Database database) {
        super(database);
    }
    @Override
    public Collection<Employee> getAll(){
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
    protected void onModelBuilder(ModelBuilder builder) {
        builder.applyConfiguration(new EmployeeConfiguration());
        builder.applyConfiguration(new BacklogConfiguration());
    }
}
