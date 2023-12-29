package org.example;

public class Employee {
    private String employeeId;
    private String employeeName;
    private double salary;
    private Department department;

    public Employee(String employeeId, String employeeName, double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
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
}
