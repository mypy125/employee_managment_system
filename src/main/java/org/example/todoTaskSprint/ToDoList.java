package org.example.todoTaskSprint;

import org.example.Calendar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ToDoList{
//-----------------------------------------------------------region fill
    private Calendar calendar;
    private List<Task> tasks;
//-----------------------------------------------------------region construction
    public ToDoList() {
        this.tasks = new ArrayList<>();
        this.calendar = new Calendar();
    }
//-----------------------------------------------------------region method
    public void addTask(String description, Priority priority, LocalDate endDate) {
        tasks.add(new Task(description,priority,endDate));
    }

    public void markTaskAsDone(int taskIndex) {
        if (isValidIndex(taskIndex)) {
            tasks.get(taskIndex).markAsDone();
        } else {
            System.out.println("Invalid task index");
        }
    }

    public void viewTasks() {
        if (!tasks.isEmpty()) {
            System.out.println("Список дел в бэклоге спринта:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        } else {
            System.out.println("В списке дел бэклога спринта нет задач.");
        }
    }
    public void addCalendar(){
        for(Task task : tasks){
            calendar.addEvent(task.getEndDate(),task.getDescription());
            System.out.println("sprint added Calendar");
        }
    }
    public Task getTaskByPriority(Priority priority){
        for(Task task : tasks){
            if(task.getPriority().equals(priority)){
                return task;
            }
        }
        return null;
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < tasks.size();
    }
}
