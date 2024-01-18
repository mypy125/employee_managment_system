package org.example.model.employee;

import org.example.model.department.Department;
import org.example.model.Access;

import java.util.Objects;

public class EmployeeUser extends EntityEmployee {
//----------------------------------------------region fill
    private double salary;
    private Access access;

//-------------------------------------------------region construction

    public EmployeeUser(String name, String surname, String mail, String password, double salary) {
        super(name, surname, mail, password);
        this.salary = salary;
        this.access = Access.THIRD;
    }

    public EmployeeUser(){}

//-----------------------------------------------------region get and set
    public double getSalary() {
        return salary;
    }
    public Access getAccess() {return access;}

//-----------------------------------------------------------------------------------------------region method

    public static EmployeeUser getEmployeeUser(String name, String surname, String mail, String password, double salary){
        if(!isValidAccount(name,surname, mail, password,salary)){
            throw new IllegalStateException("NoValid Data: "+ name + surname + mail + password + salary);
        }
        return new EmployeeUser(name,surname, mail, password,salary);
    }

//------------------------------------------------------------------------------------------validation method

    public static boolean isValidAccount(String name, String surname, String mail, String password, double salary){
        return  name != null && surname != null && mail != null && password != null && salary != 0 ;
    }
    public boolean authenticate(String enteredPassword) {
        return Objects.equals(getPassword(), enteredPassword);
    }
    public static boolean isValidDepartment(Department department) {
        return department.getDepartmentName() != null;
    }
}
