package org.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDirectory {
    private List<Employee> employeeList;

    public EmployeeDirectory() {
        this.employeeList = new ArrayList<>();
    }

    public void addEmployee(int employeeId, String phoneNumber, String name, int experience) {
        Employee employee = new Employee(employeeId, phoneNumber, name, experience);
        employeeList.add(employee);
    }

    public List<Employee> findEmployeesByExperience(int targetExperience) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee.getExperience() == targetExperience) {
                result.add(employee);
            }
        }
        return result;
    }

    public List<String> findPhoneNumbersByName(String targetName) {
        List<String> result = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee.getName().equalsIgnoreCase(targetName)) {
                result.add(employee.getPhoneNumber());
            }
        }
        return result;
    }

    public Employee findEmployeeByEmployeeId(int targetEmployeeId) {
        for (Employee employee : employeeList) {
            if (employee.getEmployeeId() == targetEmployeeId) {
                return employee;
            }
        }
        return null;
    }
}
