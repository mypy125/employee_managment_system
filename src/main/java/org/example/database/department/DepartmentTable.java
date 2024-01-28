package org.example.database.department;

import org.example.database.employee.EmployeeRecord;
import org.example.domain.department.Department;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import static java.lang.String.valueOf;

public class DepartmentTable {
    private Random random = new Random();
    private Collection<DepartmentRecord> departmentRecords;
    public Collection<DepartmentRecord> getRecords(){
        prepareRecords();
        return departmentRecords;
    }

    private void prepareRecords() {
        if(departmentRecords == null){
            departmentRecords = new ArrayList<>();
            int recordCount = 5 + random.nextInt(10);
            for(int i = 0; i < recordCount; i++){
                departmentRecords.add(new DepartmentRecord(i,"name #"+i));
            }
        }
    }

}
