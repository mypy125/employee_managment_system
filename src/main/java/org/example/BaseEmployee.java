package org.example;

public class BaseEmployee {
//------------------------------------------region fill
    private static int gID;
    private int employeeId;
    private String employeeName;
    private String employeeSurname;
//--------------------------------------------------------region construction
    public BaseEmployee(String employeeName, String employeeSurname) {
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
        this.employeeId = gID++;
    }
//------------------------------------------------region get and set
    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

}
