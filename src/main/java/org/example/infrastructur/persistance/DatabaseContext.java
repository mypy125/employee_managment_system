package org.example.infrastructur.persistance;

import org.example.application.interfaces.EmployeeDatabaseContext;
import org.example.database.EmployeeDatabase;
import org.example.database.EmployeeRecord;
import org.example.domain.employee.Employee;
import org.example.infrastructur.persistance.configurations.EmployeeConfiguration;

import java.util.ArrayList;
import java.util.Collection;

public class DatabaseContext extends DbContext implements EmployeeDatabaseContext {
    public DatabaseContext(Database database) {
        super(database);
    }

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
    protected void onModelBuilder(ModelBuilder builder) {
        builder.applyConfiguration(new EmployeeConfiguration());
    }
}
