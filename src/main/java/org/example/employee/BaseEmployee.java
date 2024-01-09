package org.example.employee;

import org.example.Department;

public class BaseEmployee {
//------------------------------------------region fill
    private static int gID;
    private int employeeId;
    private String employeeName;
    private String employeeSurname;
    private String employeeMail;
    private Department department;
    private Access access;
//--------------------------------------------------------region construction
    public BaseEmployee(String employeeName, String employeeSurname,String employeeMail) {
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
        this.employeeMail = employeeMail;
        this.access = Access.FIRST;
        this.employeeId = gID++;
    }
//------------------------------------------------region get and set
    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public String getEmployeeMail() {
        return employeeMail;
    }

    public Access getAccess() {
        return access;
    }

    public void assignDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public double getSalary() {
        return 0;
    }

    public String getDepartmentName() {
        return null;
    }
}
