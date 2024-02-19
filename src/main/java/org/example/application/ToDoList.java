package org.example.application;

import org.example.Calendar;
import org.example.domain.sprint.Priority;
import org.example.domain.sprint.Sprint;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ToDoList{
//-----------------------------------------------------------region fill
    private Calendar calendar;
    private List<Sprint> sprints;
    //private Task task;
//-----------------------------------------------------------region construction
    public ToDoList() {
        this.sprints = new ArrayList<>();
        this.calendar = new Calendar();
    }
//-----------------------------------------------------------region method
    public void addTask(String description, Priority priority, LocalDate endDate) {
        sprints.add(new Sprint());
    }

    public void markTaskAsDone(int taskIndex) {
        if (isValidIndex(taskIndex)) {
            sprints.get(taskIndex).isDone();
        } else {
            System.out.println("Invalid task index");
        }
    }

    public void viewTasks() {
        if (!sprints.isEmpty()) {
            System.out.println("Список дел в бэклоге спринта:");
            for (int i = 0; i < sprints.size(); i++) {
                System.out.println((i + 1) + ". " + sprints.get(i));
            }
        } else {
            System.out.println("В списке дел бэклога спринта нет задач.");
        }
    }
    public void addCalendar(){
        for(Sprint sprint : sprints){
            calendar.addEvent(sprint.getEndDate(), sprint.getDescription());
            System.out.println("sprint added Calendar");
        }
    }
    public Sprint getTaskByPriority(Priority priority){
        for(Sprint sprint : sprints){
            if(sprint.getPriority().equals(priority)){
                return sprint;
            }
        }
        return null;
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < sprints.size();
    }
}
