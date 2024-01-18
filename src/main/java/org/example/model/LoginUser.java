package org.example.model;

import org.example.model.employee.BaseEmployee;

public interface LoginUser <T extends BaseEmployee>{
    T login(String username, String password);


}
