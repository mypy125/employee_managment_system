package org.example;

import java.util.Objects;

public class Employee {
//----------------------------------------------region fill
    private String employeeId;
    private String employeeName;
    private double salary;
    private String username;
    private String password;
    private Access access;
    private Department department;
//-------------------------------------------------region construction

    public Employee(String employeeId, String employeeName, double salary, String username, String password,Access access) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
        this.username = username;
        this.password = password;
        this.access = access;
    }
    private Employee(){}
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
    public Access getAccess() {return access;}
    public Department getDepartment() {return department;}
    public void assignDepartment(Department department) {
        this.department = department;
    }

//-----------------------------------------------------------------------------------------------region method

    public static Employee registerEmployee(String employeeId, String employeeName, double salary,
                                            String username, String password,Access access) {
        if (isValidAccount(employeeId,employeeName,salary,username,password,access)){
            System.out.println("невалидные данны");
        }
        return new Employee(employeeId, employeeName, salary, username, password, access);
    }

    public static Employee login(String username, String password, Employee[] employees) {
        for (Employee employee : employees) {
            if (employee.getUsername().equals(username) && employee.authenticate(password)) {
                return employee;
            }
        }
        return null;
    }
//------------------------------------------------------------------------------------------validation method

    public boolean authenticate(String enteredPassword) {
        return Objects.equals(password, enteredPassword);
    }
    public static boolean isValidAccount(String employeeId, String employeeName, double salary,
                                         String username, String password,Access access){
        return employeeId != null && employeeName != null && username != null && password != null &&
                salary != 0 && access != null;
    }
    static boolean isValidDepartment(Department department) {
        return department.getDepartmentId() != null && department.getDepartmentName() != null;
    }

}
