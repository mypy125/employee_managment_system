package org.example.controller;

import org.example.model.department.Department;
import org.example.StaffManagementSystem;
import org.example.model.LoginUser;
import org.example.model.employee.EntityEmployee;
import org.example.model.employee.EmployeeUser;
import org.example.model.productBacklog.BacklogItem;
import org.example.model.productBacklog.ProductBacklog;

import java.util.*;

public class EmployeeManagementSystem<T extends EntityEmployee> implements StaffManagementSystem, LoginUser {
//-----------------------------------------------region fill
    private Map<String, T> employees;
    private List<Department> departments;
    private ProductBacklog productBacklogs;
//-----------------------------------------------region construction

    public EmployeeManagementSystem() {
        this.employees = new HashMap<>();
        this.departments = new ArrayList<>();
        this.productBacklogs = new ProductBacklog(new BacklogItem());
    }
//---------------------------------------------------------------region method

    public void addEmployee(T employee) {
        employees.put(employee.getName(),employee);
    }
    public void addDepartment(Department department) {
        if(!EmployeeUser.isValidDepartment(department)){
            System.out.println("заполните все поля департамента!");
        }
        departments.add(department);
    }
//---------------------------------------------------------------------region employee assign system
    public void assignEmployeeToDepartment(String employeeName, String departmentName) {
        T employee = findEmployeeByName(employeeName);
        Department department = findDepartmentByName(departmentName);

        if (employee != null && department != null) {
            employee.assignDepartment(department);
        } else {
            System.out.println("Сотрудник или отдел не найден.");
        }
    }
    public void assignEmployeeToProject(String employeeName, String itemName) {
        T employee = findEmployeeByName(employeeName);
        BacklogItem product = findBacklogItemsByName(itemName);
        if (employee != null && product != null) {
            employee.assignToProject(product);
        }
    }
//---------------------------------------------------------end region employee assign system
    public void displayEmployeeInformation(String employeeName) {
        T employee = findEmployeeByName(employeeName);
        if (employee != null) {
            System.out.println("Employee Name: " + employee.getName());
            System.out.println("Employee Email: " + employee.getMail());
            System.out.println("Salary: $" + employee.getSalary());
            Department department = employee.getDepartment();
            if (department != null) {
                System.out.println("Департамент: " + department.getDepartmentName());
            } else {
                System.out.println("Департамент: Не назначен");
            }
        } else {
            System.out.println("Сотрудник не найден по ID: " + employeeName);
        }
    }
//----------------------------------------------------------find employee,department,backlog byName
    private T findEmployeeByName(String employeeName) {
        for (T employee : employees.values()) {
            if (employee.getName().equals(employeeName)) {
                return employee;
            }
        }
        return null;
    }
    private Department findDepartmentByName(String departmentName) {
        for (Department department : departments) {
            if (department.getDepartmentName().equals(departmentName)) {
                return department;
            }
        }
        return null;
    }
    private BacklogItem findBacklogItemsByName(String itemName){
        for(BacklogItem backlogItem : productBacklogs.getBacklogItems()){
            if (backlogItem.getItemName().equals(itemName)){
                return backlogItem;
            }
        }
        return null;
    }

//---------------------------------------------------------------------login system
    @Override
    public T login(String username, String password) {
        for (T employee : employees.values()) {
            if (employee.getName().equals(username) && employee.authenticate(password)) {
                System.out.println("employee login");
                return employee;
            }
        }
        return null;
    }


//---------------------------------------------------------------analytic method
    @Override
    public int getEmployeeCount() {
        return employees.size();
    }
    @Override
    public double getAverageSalary() {
        if (employees.size() == 0) {
            return 0.0;
        }

        double totalSalary = 0;
        for (T employee : employees.values()) {
            totalSalary += employee.getSalary();
        }

        return totalSalary / employees.size();
    }
    @Override
    public void generateBasicReport() {
        System.out.println("Базовый отчет сотрудников:");
        System.out.println("Количество сотрудников: " + getEmployeeCount());
        System.out.println("Средняя заработная плата: " + getAverageSalary());
    }

}
