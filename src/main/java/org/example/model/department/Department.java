package org.example.model.department;

public class Department {
//------------------------------------------region fill
    private static int gID;
    private int departmentId;
    private String departmentName;
//----------------------------------------------region construction

    public Department(String departmentName) {
        this.departmentId = gID++;
        this.departmentName = departmentName;
    }
//-----------------------------------------------region get and set
    public int getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}
