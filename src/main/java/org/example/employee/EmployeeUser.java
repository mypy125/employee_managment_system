package org.example.employee;

import org.example.Department;
import org.example.productBacklog.BacklogItem;

import java.util.Objects;

public class EmployeeUser extends BaseEmployee {
//----------------------------------------------region fill
    private double salary;
    private String username;
    private String password;
    private Access access;

//-------------------------------------------------region construction
    private EmployeeUser(String employeeName, String employeeSurname, String employeeMail, double salary,
                        String username, String password) {
       super(employeeName,employeeSurname,employeeMail);
        this.salary = salary;
        this.username = username;
        this.password = password;
        this.access = Access.SECOND;
    }
    public EmployeeUser(){}

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

//-----------------------------------------------------------------------------------------------region method

    public static EmployeeUser getEmployeeUser(String employeeName, String employeeSurname, String employeeMail, double salary,
                                               String username, String password){
        if(!isValidAccount(employeeName,employeeSurname, salary, username, password)){
            throw new IllegalStateException("NoValid Data: "+ employeeName + employeeSurname + salary + username + password);
        }
        return new EmployeeUser(employeeName,employeeSurname,employeeMail,salary,username,password);
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
