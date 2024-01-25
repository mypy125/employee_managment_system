package org.example.database.backlog;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class BacklogTable {
    private Random random = new Random();
    private Collection<BacklogRecord> backlogRecords;
    public Collection<BacklogRecord> getRecords() {
        prepareRecords();
        return backlogRecords;
    }

    private void prepareRecords() {
        if(backlogRecords == null){
            backlogRecords = new ArrayList<>();
            int recordCount = 5 + random.nextInt(10);
            for(int i = 0; i < recordCount; i++){
                backlogRecords.add(new BacklogRecord("name "+i,",surname "+i));
            }
        }
    }
}
