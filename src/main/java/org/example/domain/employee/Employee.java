package org.example.domain.employee;

import org.example.domain.Entity;

public class Employee implements Entity {
    private int id;
    private String name;
    private String surname;
    private String mail;
    private double salary;
    private String password;
    private Access access;

    public Employee(int id, String name, String surname, String mail, double salary, String password, Access access) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.salary = salary;
        this.password = password;
        this.access = access;
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

    public double getSalary() {
        return salary;
    }

    public String getPassword() {
        return password;
    }

    public Access getAccess() {
        return access;
    }

    @Override
    public int getId() {
        return id;
    }
}
