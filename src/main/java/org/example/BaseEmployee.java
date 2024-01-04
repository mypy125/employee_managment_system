package org.example;

public class BaseEmployee {
//------------------------------------------region fill
    private String employeeId;
    private String employeeName;
    private String employeeSurname;
//--------------------------------------------------------region construction
    public BaseEmployee(String employeeId, String employeeName, String employeeSurname) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
    }
//------------------------------------------------region get and set
    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

}
