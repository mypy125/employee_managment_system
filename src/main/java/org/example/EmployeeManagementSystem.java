package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.example.Employee.*;

public class EmployeeManagementSystem implements StaffManagementSystem{
//-----------------------------------------------region fill
    private Map<String, Employee> employees;
    private List<Department> departments;
//-----------------------------------------------region construction

    public EmployeeManagementSystem() {
        this.employees = new HashMap();
        this.departments = new ArrayList<>();
    }
//---------------------------------------------------------------region method

    public void addEmployee(Employee employee) {
        employees.put(employee.getUsername(),employee);
    }
    public void addDepartment(Department department) {
        if(!isValidDepartment(department)){
            System.out.println("заполните все поля департамента!");
        }
        departments.add(department);
    }
    public void assignEmployeeToDepartment(String employeeId, String departmentId) {
        Employee employee = findEmployeeById(employeeId);
        Department department = findDepartmentById(departmentId);

        if (employee != null && department != null) {
            employee.assignDepartment(department);
        } else {
            System.out.println("Сотрудник или отдел не найден.");
        }
    }
    public void displayEmployeeInformation(String employeeId) {
        Employee employee = findEmployeeById(employeeId);
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
            System.out.println("Сотрудник не найден по ID: " + employeeId);
        }
    }
    private Employee findEmployeeById(String employeeId) {
        for (Employee employee : employees.values()) {
            if (employee.getEmployeeId().equals(employeeId)) {
                return employee;
            }
        }
        return null;
    }
    private Department findDepartmentById(String departmentId) {
        for (Department department : departments) {
            if (department.getDepartmentId().equals(departmentId)) {
                return department;
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
        for (Employee employee : employees.values()) {
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
