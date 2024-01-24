package org.example.domain.department;

import org.example.domain.Entity;

public class Department implements Entity {
//------------------------------------------region fill
    private int departmentId;
    private String departmentName;
//----------------------------------------------region construction


    public Department(int departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    //-----------------------------------------------region get and set

    public String getDepartmentName() {
        return departmentName;
    }

    @Override
    public int getId() {
        return departmentId;
    }
}
