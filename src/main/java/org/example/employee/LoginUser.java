package org.example.employee;

public interface LoginUser <T extends BaseEmployee>{
    T login(String username, String password);


}
