package org.example.model.employee;

import org.example.model.department.Department;
import org.example.model.Access;
import org.example.model.productBacklog.BacklogItem;

import java.util.Objects;

public class EntityEmployee {
//------------------------------------------region fill
    private String name;
    private String surname;
    private String mail;
    private String password;
    private Access access;
    private Department department;
    private BacklogItem backlogItem;

//--------------------------------------------------------region construction
    public EntityEmployee(String name, String surname, String mail, String password) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.password = password;
        this.access = Access.FIRST;
    }
    public EntityEmployee(){}
//------------------------------------------------region get and set
    public static EntityEmployee getBaseEmployee(String name, String surname, String mail, String password){
        return new EntityEmployee(name, surname,mail,password);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMail() {
        return mail;
    }
    public String getPassword() {
        return password;
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


    public boolean authenticate(String enteredPassword) {
        return Objects.equals(password, enteredPassword);
    }

}
