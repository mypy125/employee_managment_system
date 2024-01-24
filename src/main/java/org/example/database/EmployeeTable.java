package org.example.database;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class EmployeeTable {
    Random random = new Random();
    private Collection<EmployeeRecord> employeeRecords;

    public Collection<EmployeeRecord> getRecords() {
        prepareRecords();
        return employeeRecords;
    }

    private void prepareRecords(){
        if(employeeRecords == null){
            employeeRecords = new ArrayList<>();
            int recordCount = 5 + random.nextInt(10);
            for(int i = 0; i < recordCount; i++){
                employeeRecords.add(new EmployeeRecord("name "+i,",surname "+i));
            }

        }
    }
}
