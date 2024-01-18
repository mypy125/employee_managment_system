package org.example.model;

import org.example.model.employee.EntityEmployee;

public interface LoginUser <T extends EntityEmployee>{
    T login(String username, String password);


}
