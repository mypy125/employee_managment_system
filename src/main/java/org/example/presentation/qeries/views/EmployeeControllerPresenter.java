package org.example.presentation.qeries.views;

import org.example.application.interfaces.EmployeePresenter;
import org.example.domain.employee.Employee;

import java.util.Collection;

public class EmployeeControllerPresenter implements EmployeePresenter {

    @Override
    public void printAll(Collection<Employee> employee) {
        for(Employee employ : employee){
            System.out.println(employ.getId());
        }
    }
}
