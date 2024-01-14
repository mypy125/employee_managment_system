package org.example.employee;

import org.example.Department;
import org.example.productBacklog.BacklogItem;
import org.example.productBacklog.ProductBacklog;

public class BaseEmployee {
//------------------------------------------region fill
    private String employeeName;
    private String employeeSurname;
    private String employeeMail;
    private Access access;
    private Department department;
    private BacklogItem backlogItem;
//--------------------------------------------------------region construction
    public BaseEmployee(String employeeName, String employeeSurname,String employeeMail) {
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
        this.employeeMail = employeeMail;
        this.access = Access.FIRST;
    }
    public BaseEmployee(){}
//------------------------------------------------region get and set
    public static BaseEmployee getBaseEmployee(String employeeName, String employeeSurname,String employeeMail){
        return new BaseEmployee(employeeName,employeeSurname,employeeMail);
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
    public void assignToProject(BacklogItem backlogItem){
        this.backlogItem = backlogItem;
    }

    public Object getUsername() {
        return null;
    }

    public boolean authenticate(String password) {
        return false;
    }
}
