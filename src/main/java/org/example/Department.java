package org.example;

public class Department {
//------------------------------------------region fill
    private String departmentId;
    private String departmentName;
//----------------------------------------------region construction

    public Department(String departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }
//-----------------------------------------------region get and set
    public String getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}
