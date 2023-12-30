package org.example;

import java.util.HashMap;
import java.util.Map;

public class LoginUser {
    private Map<String,Employee> users;

    public LoginUser() {
        this.users = new HashMap<>();
    }

    public void registerEmployee(Employee employee) {
        users.put(employee.getUsername(), employee);
    }

    public boolean login(String username, String password) {
        Employee employee = users.get(username);
        return employee != null && employee.authenticate(password);
    }
}
