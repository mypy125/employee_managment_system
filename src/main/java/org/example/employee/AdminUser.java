package org.example.employee;

public class AdminUser extends BaseEmployee{
    private Access access;
    public AdminUser(){}
    public AdminUser(String employeeName, String employeeSurname, String employeeMail) {
        super(employeeName, employeeSurname, employeeMail);
        this.access = Access.THIRD;
    }

    @Override
    public Access getAccess() {
        return access;
    }
}
