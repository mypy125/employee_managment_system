package org.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagementSystem {
    private List<Employee> employees;
    private List<Department> departments;

    public EmployeeManagementSystem() {
        this.employees = new ArrayList<>();
        this.departments = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void assignEmployeeToDepartment(String employeeId, String departmentId) {
        Employee employee = findEmployeeById(employeeId);
        Department department = findDepartmentById(departmentId);

        if (employee != null && department != null) {
            employee.assignDepartment(department);
        } else {
            System.out.println("Employee or Department not found.");
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
                System.out.println("Department: " + department.getDepartmentName());
            } else {
                System.out.println("Department: Not Assigned");
            }
        } else {
            System.out.println("Employee not found with ID: " + employeeId);
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
}
