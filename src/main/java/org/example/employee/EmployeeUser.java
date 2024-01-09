package org.example.employee;

import org.example.Department;

import java.util.Objects;

public class EmployeeUser extends BaseEmployee {
//----------------------------------------------region fill
    private double salary;
    private String username;
    private String password;
    private Access access;
    private Department department;
//-------------------------------------------------region construction

    public EmployeeUser(String employeeName, String employeeSurname, String employeeMail, double salary,
                        String username, String password) {
       super(employeeName,employeeSurname,employeeMail);
        this.salary = salary;
        this.username = username;
        this.password = password;
        this.access = Access.SECOND;
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

    public static EmployeeUser registerEmployee(String employeeName, String employeeSurname, String employeeMail,
                                                double salary, String username, String password) {
        if (isValidAccount(employeeName,employeeSurname,salary,username,password)){
            System.out.println("невалидные данны");
        }
        return new EmployeeUser(employeeName,employeeSurname,employeeMail, salary, username, password);
    }

    public static EmployeeUser login(String username, String password, EmployeeUser[] employees) {
        for (EmployeeUser employee : employees) {
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
    public static boolean isValidAccount(String employeeName,String employeeSurname, double salary,
                                         String username, String password){
        return  employeeName != null && employeeSurname != null && username != null && password != null &&
                salary != 0 ;
    }
    static boolean isValidDepartment(Department department) {
        return department.getDepartmentName() != null;
    }

}
