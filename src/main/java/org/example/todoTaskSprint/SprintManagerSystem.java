package org.example.todoTaskSprint;

import org.example.Calendar;
import org.example.todoTaskSprint.Priority;
import org.example.todoTaskSprint.Task;

import java.util.ArrayList;
import java.util.List;

public class SprintManagerSystem {
//-----------------------------------------------region fill
    private Calendar calendar;
    private List<Task> taskList;

//-----------------------------------------------region construction
    public SprintManagerSystem(){
        this.taskList = new ArrayList<>();
    }
//---------------------------------------------------------------region method
    public void addSprint(Task task){
        taskList.add(task);
    }
    public Task getTaskByPriority(Priority priority){
        for(Task task : taskList){
            if(task.getPriority().equals(priority)){
                return task;
            }
        }
        return null;
    }

    public void addCalendar(){
        for(Task task : taskList){
            calendar.addEvent(task.getLocalDate(), task);
            System.out.println("sprint added Calendar");
        }
    }

}
