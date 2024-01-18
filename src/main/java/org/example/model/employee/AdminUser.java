package org.example.model.employee;

import org.example.model.Access;

public class AdminUser extends EntityEmployee {
//---------------------------------region fill
    private Access access;
//------------------------------------------------------------region construction

    public AdminUser(String name, String surname, String mail, String password) {
        super(name, surname, mail, password);
        this.access = Access.FIRST;
    }

    public AdminUser(){}
//----------------------------------------------------------------------region method
    public static AdminUser getAdminUser(String name, String surname, String mail, String password){
        return new AdminUser(name, surname, mail, password);
    }

    @Override
    public Access getAccess() {
        return access;
    }

}
