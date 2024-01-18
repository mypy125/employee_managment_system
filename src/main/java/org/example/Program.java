package org.example;

import org.example.model.department.Department;
import org.example.model.employee.AdminUser;
import org.example.model.employee.BaseEmployee;
import org.example.controller.EmployeeManagementSystem;
import org.example.model.employee.EmployeeUser;
import org.example.model.EmployeeType;
import org.example.model.employee.userFactory.UserFactory;
import org.example.model.productBacklog.ProductBacklog;
import org.example.model.todoTaskSprint.Priority;
import org.example.controller.ToDoList;

import java.time.LocalDate;

public class Program {
    public static void main(String[] args) {
        BaseEmployee user = AdminUser.getAdminUser("gor","mkhitaryan","gor@gmail.com");
        BaseEmployee user2 = BaseEmployee.getBaseEmployee("sveta","isakova","svis@gmail.com");
        BaseEmployee user3 = EmployeeUser.getEmployeeUser("sasha","emelyanov","vasil@mail.ru",1500,"SM","1234");

        Department department1 = new Department("developer");
        Department department2 = new Department("QA");

        ProductBacklog productBacklog = new ProductBacklog("product1","add new functional for sales",LocalDate.MIN,LocalDate.MAX);
        productBacklog.addItem(productBacklog);

        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        ems.addDepartment(department1);
        ems.addDepartment(department2);
        ems.addEmployee(user);
        ems.addEmployee(user2);
        ems.addEmployee(user3);
        ems.assignEmployeeToDepartment("sasha","developer");
        ems.assignEmployeeToDepartment("sveta","QA");
        ems.generateBasicReport();
        ems.assignEmployeeToProject("gor","product1");
        //ems.login("SM","1234");


        ToDoList list = new ToDoList();
        list.addTask("create searching system...", Priority.MEDIUM, LocalDate.now());
        list.addTask("create database system...", Priority.HIGH, LocalDate.now());
        list.viewTasks();
        list.addCalendar();

        Calendar calendar = new Calendar();
        calendar.viewCalendar(LocalDate.now());


//------------------------------------------------fabric method
        UserFactory users = new UserFactory();
        users.getEmployee(EmployeeType.ADMIN);
        users.getEmployee(EmployeeType.BASE);
        users.getEmployee(EmployeeType.USER);

    }
}
