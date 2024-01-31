package org.example.presentation.qeries.controllers;

import org.example.application.interfaces.EmployeeEditor;
import org.example.domain.employee.Employee;

public class EmployeeController extends Controller{
    private final EmployeeEditor employeeEditor;
    public EmployeeController(EmployeeEditor employeeEditor){
        this.employeeEditor = employeeEditor;
    }
    void routAddEmployee(Employee employee){
        this.employeeEditor.add(employee);
    }

    void routRemoveEmployee(Employee employee){
        this.employeeEditor.remove(employee);
    }

    void routGetAll(){
        this.employeeEditor.getAll();
    }
}
