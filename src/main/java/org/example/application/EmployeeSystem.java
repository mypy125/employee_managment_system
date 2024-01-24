package org.example.application;

import org.example.domain.department.Department;
import org.example.domain.backlog.Backlog;


import java.util.*;

public class EmployeeSystem {
//-----------------------------------------------region fill
    private Map<String, String> employees;
    private List<Department> departments;
    private Backlog productBacklogs;
//-----------------------------------------------region construction

    public EmployeeSystem() {

    }
//---------------------------------------------------------------region method

    public void addEmployee() {

    }
    public void addDepartment() {

    }
//---------------------------------------------------------------------region employee assign system
    public void assignEmployeeToDepartment() {

    }
    public void assignEmployeeToProject() {

    }
//---------------------------------------------------------end region employee assign system
    public void displayEmployeeInformation() {

    }
//----------------------------------------------------------find employee,department,backlog byName
    private String findEmployeeByName() {
      return null;
    }
    private Department findDepartmentByName(String departmentName) {
        for (Department department : departments) {
            if (department.getDepartmentName().equals(departmentName)) {
                return department;
            }
        }
        return null;
    }
    private Backlog findBacklogItemsByName(){
        return null;
    }

//---------------------------------------------------------------------login system



//---------------------------------------------------------------analytic method



}
