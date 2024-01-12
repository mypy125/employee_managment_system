package org.example.employee;

public class AdminUser extends BaseEmployee{
//---------------------------------region fill
    private Access access;
//------------------------------------------------------------region construction
    private AdminUser(String employeeName, String employeeSurname, String employeeMail) {
        super(employeeName, employeeSurname, employeeMail);
        this.access = Access.THIRD;
    }
    public AdminUser(){}
//----------------------------------------------------------------------region method
    public static AdminUser getAdminUser(String employeeName, String employeeSurname, String employeeMail){
        return new AdminUser(employeeName,employeeSurname, employeeMail);
    }

    @Override
    public Access getAccess() {
        return access;
    }

}
