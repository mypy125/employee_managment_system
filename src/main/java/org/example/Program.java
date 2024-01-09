package org.example;

import org.example.employee.AdminUser;
import org.example.employee.BaseEmployee;
import org.example.employee.EmployeeManagementSystem;
import org.example.employee.EmployeeUser;
import org.example.todoTaskSprint.Priority;
import org.example.todoTaskSprint.ToDoList;

import java.time.LocalDate;

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
        ems.generateBasicReport();

        Calendar calendar = new Calendar();
        ToDoList list = new ToDoList();
        list.addTask("create searching system...", Priority.HIGH, LocalDate.of(11,5,8));
        list.addTask("create database system...", Priority.HIGH, LocalDate.of(11,9,8));
        list.viewTasks();




    }
}
