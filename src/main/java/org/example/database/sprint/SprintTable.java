package org.example.database.sprint;

import org.example.database.employee.EmployeeRecord;
import org.example.domain.sprint.Priority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class SprintTable {
    private Random random = new Random();
    private Collection<SprintRecord> sprintRecords;
    public Collection<SprintRecord> getRecords(){
        prepareRecords();
        return sprintRecords;
    }

    private void prepareRecords() {
        if(sprintRecords != null){
            sprintRecords = new ArrayList<>();
            int recordCount = 5 + random.nextInt(15);
            for (int i = 0; i < recordCount ; i++) {
                sprintRecords.add(new SprintRecord("description"+i,Priority.HIGH));
            }
        }
    }


}
