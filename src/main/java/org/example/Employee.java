package org.example;

import java.util.Objects;

public class Employee extends BaseEmployee {
//----------------------------------------------region fill
    private double salary;
    private String username;
    private String password;
    private Access access;
    private Department department;
//-------------------------------------------------region construction

    public Employee(String employeeName,String employeeSurname, double salary, String username, String password,Access access) {
       super(employeeName,employeeSurname);
        this.salary = salary;
        this.username = username;
        this.password = password;
        this.access = access;
    }

//-----------------------------------------------------region get and set

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
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

    public static Employee registerEmployee(String employeeId, String employeeName,String employeeSurname, double salary,
                                            String username, String password,Access access) {
        if (isValidAccount(employeeId,employeeName,employeeSurname,salary,username,password,access)){
            System.out.println("невалидные данны");
        }
        return new Employee(employeeName,employeeSurname, salary, username, password, access);
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
    public static boolean isValidAccount(String employeeId,String employeeName,String employeeSurname, double salary,
                                         String username, String password,Access access){
        return employeeId != null && employeeName != null && username != null && password != null &&
                salary != 0 && access != null;
    }
    static boolean isValidDepartment(Department department) {
        return department.getDepartmentId() != 0 && department.getDepartmentName() != null;
    }

}
