package org.example;

import org.example.employee.AdminUser;
import org.example.employee.BaseEmployee;
import org.example.employee.EmployeeManagementSystem;
import org.example.employee.EmployeeUser;

public class Program {
    public static void main(String[] args) {
        AdminUser user = new AdminUser("gor","mkhitaryan","gor@gmail.com");
        BaseEmployee user2 = new BaseEmployee("sveta","isakova","svis@gmail.com");
        EmployeeUser user3 = new EmployeeUser("sasha","emelyanov","vasil@mail.ru",250,"SM","1234");

        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        ems.addEmployee(user);

    }
}
