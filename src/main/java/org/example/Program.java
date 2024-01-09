package org.example;

import org.example.employee.AdminUser;
import org.example.employee.BaseEmployee;
import org.example.employee.EmployeeManagementSystem;
import org.example.employee.EmployeeUser;

public class Program {
    public static void main(String[] args) {
        AdminUser user = new AdminUser("gor","mkhitaryan","gor@gmail.com");
        BaseEmployee user2 = new BaseEmployee("sveta","isakova","svis@gmail.com");
        EmployeeUser user3 = new EmployeeUser("sasha","emelyanov","vasil@mail.ru",1500,"SM","1234");

        Department department1 = new Department("developer");
        Department department2 = new Department("QA");

        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        ems.addDepartment(department1);
        ems.addDepartment(department2);
        ems.addEmployee(user);
        ems.addEmployee(user2);
        ems.addEmployee(user3);
        ems.assignEmployeeToDepartment("sasha","developer");
        ems.assignEmployeeToDepartment("sveta","QA");

        System.out.println(ems.getEmployeeCount());
        ems.generateBasicReport();


    }
}