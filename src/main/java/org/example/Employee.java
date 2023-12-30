package org.example;

import java.util.Objects;

public class Employee {
//----------------------------------------------region fill
    private String employeeId;
    private String employeeName;
    private double salary;
    private String username;
    private String password;
    private Department department;
//-------------------------------------------------region construction
    public Employee(String employeeId, String employeeName, double salary,String username, String password) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
        this.username = username;
        this.password = password;
    }
//-----------------------------------------------------region get and set
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getEmployeeId() {
        return employeeId;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public double getSalary() {
        return salary;
    }
    public Department getDepartment() {
        return department;
    }
    public void assignDepartment(Department department) {
        this.department = department;
    }
    public boolean authenticate(String enteredPassword) {
        return Objects.equals(password, enteredPassword);
    }

}
