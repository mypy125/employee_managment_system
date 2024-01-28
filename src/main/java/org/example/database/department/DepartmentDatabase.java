package org.example.database.department;

public class DepartmentDatabase {
    DepartmentTable departmentTable = new DepartmentTable();
    public DepartmentTable getDepartmentTable(){
        return departmentTable;
    }
}
