package org.example;

import java.util.ArrayList;
import java.util.List;

public class SprintManagerSystem {
//-----------------------------------------------region fill
    private Calendar calendar;
    private List<Sprint> sprintList;

//-----------------------------------------------region construction
    public SprintManagerSystem(){
        this.sprintList = new ArrayList<>();
    }
//---------------------------------------------------------------region method
    public void addSprint(Sprint sprint){
        sprintList.add(sprint);
    }
    public Sprint getSprintByName(String name){
        for(Sprint sprint : sprintList){
            if(sprint.getName().equals(name)){
                return sprint;
            }
        }
        return null;
    }

    public Sprint getSprintByPriority(Priority priority){
        for(Sprint sprint : sprintList){
            if(sprint.getPriority().equals(priority)){
                return sprint;
            }
        }
        return null;
    }
    public void addCalendar(){
        for(Sprint sprint : sprintList){
            calendar.addEvent(sprint.getStartDate(),sprint);
            System.out.println("sprint added Calendar");
        }
    }

}
