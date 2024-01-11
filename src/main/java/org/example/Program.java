package org.example;

import org.example.employee.*;
import org.example.employee.userFactory.EmployeeType;
import org.example.employee.userFactory.UserFactory;
import org.example.todoTaskSprint.Priority;
import org.example.todoTaskSprint.ToDoList;

import java.time.LocalDate;

public class Program {
    public static void main(String[] args) {
//        BaseEmployee employee1 = new UserFactory().getEmployee(EmployeeType.ADMIN);
//        BaseEmployee employee2 = new UserFactory().getEmployee(EmployeeType.USER);
//        BaseEmployee employee3 = new UserFactory().getEmployee(EmployeeType.BASE);

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


        ToDoList list = new ToDoList();
        list.addTask("create searching system...", Priority.MEDIUM, LocalDate.now());
        list.addTask("create database system...", Priority.HIGH, LocalDate.now());
        list.viewTasks();
        list.addCalendar();

        Calendar calendar = new Calendar();
        calendar.viewCalendar(LocalDate.now());




    }
}
