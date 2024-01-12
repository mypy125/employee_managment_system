package org.example.employee;

import org.example.Department;
import org.example.StaffManagementSystem;
import org.example.employee.userFactory.CreatorEmployee;
import org.example.employee.userFactory.EmployeeType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.example.employee.EmployeeUser.*;

public class EmployeeManagementSystem<T extends BaseEmployee> implements StaffManagementSystem {
//-----------------------------------------------region fill
    private Map<String, T> employees;
    private List<Department> departments;
//-----------------------------------------------region construction

    public EmployeeManagementSystem() {
        this.employees = new HashMap<>();
        this.departments = new ArrayList<>();
    }
//---------------------------------------------------------------region method

    public void addEmployee(T employee) {
        employees.put(employee.getEmployeeName(),employee);
    }
    public void addDepartment(Department department) {
        if(!isValidDepartment(department)){
            System.out.println("заполните все поля департамента!");
        }
        departments.add(department);
    }
    public void assignEmployeeToDepartment(String employeeName, String departmentName) {
        T employee = findEmployeeByName(employeeName);
        Department department = findDepartmentByName(departmentName);

        if (employee != null && department != null) {
            employee.assignDepartment(department);
        } else {
            System.out.println("Сотрудник или отдел не найден.");
        }
    }
    public void displayEmployeeInformation(String employeeName) {
        T employee = findEmployeeByName(employeeName);
        if (employee != null) {
            System.out.println("Employee ID: " + employee.getEmployeeId());
            System.out.println("Employee Name: " + employee.getEmployeeName());
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
    private T findEmployeeByName(String employeeName) {
        for (T employee : employees.values()) {
            if (employee.getEmployeeName().equals(employeeName)) {
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

    public static EmployeeUser login(String username, String password, EmployeeUser[] employees) {
        for (EmployeeUser employee : employees) {
            if (employee.getUsername().equals(username) && employee.authenticate(password)) {
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
