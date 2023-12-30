package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeManagementSystem {
//-----------------------------------------------region fill
    private List<Employee> employees;
    private List<Department> departments;
//-----------------------------------------------region construction
    public EmployeeManagementSystem() {
        this.employees = new ArrayList<>();
        this.departments = new ArrayList<>();
    }
//---------------------------------------------------------------region method
    public void addEmployee(Employee employee) {
        if(!isValidAccount(employee)){
            System.out.println("заполните все поля аккаунта!");
        }
        employees.add(employee);
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
        for (Employee employee : employees) {
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
    public static boolean isValidAccount(Employee employee){
        return employee.getEmployeeId() != null && employee.getUsername() != null &&
                employee.getEmployeeName() != null && employee.getPassword() != null;
    }
    private boolean isValidDepartment(Department department) {
        return department.getDepartmentId() != null && department.getDepartmentName() != null;
    }


}
