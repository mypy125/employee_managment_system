package org.example.application;

import org.example.application.interfaces.presenters.EmployeePresenter;
import org.example.application.interfaces.context.EmployeeDatabaseContext;
import org.example.application.interfaces.EmployeeEditor;
import org.example.domain.employee.Employee;

import java.util.Collection;
import java.util.Optional;

public class EmployeeEdit implements EmployeeEditor {

    private final EmployeeDatabaseContext databaseContext;
    private final EmployeePresenter employeePresenter;
    public EmployeeEdit(EmployeePresenter employeePresenter,
                        EmployeeDatabaseContext databaseContext){
        this.employeePresenter = employeePresenter;
        this.databaseContext = databaseContext;

    }
    @Override
    public void printAll() {
        employeePresenter.printAll(getAll());
    }
    @Override
    public boolean add(Employee item) {
        databaseContext.getAllEmployee().add(item);
        return databaseContext.saveChanges();
    }

    @Override
    public boolean edit(Employee item) {
        if(item == null)
            return false;
        Optional<Employee> employee = getById(item.getId());
        if(employee.isEmpty())
            return false;
        employee.get().setId(item.getId());
        employee.get().setMail(item.getMail());
        employee.get().setName(item.getName());
        employee.get().setSurname(item.getSurname());
        employee.get().setAccess(item.getAccess());
        employee.get().setPassword(item.getPassword());
        employee.get().setSalary(item.getSalary());
        return databaseContext.saveChanges();
    }

    @Override
    public boolean remove(Employee item) {
        databaseContext.getAllEmployee().remove(item);
        return databaseContext.saveChanges();
    }

    @Override
    public Optional<Employee> getById(Integer integer) {
        return databaseContext.getAllEmployee().stream().filter(p -> p.getId() == integer).findFirst();
    }

    @Override
    public Collection<Employee> getAll() {
        return databaseContext.getAllEmployee();
    }


}
