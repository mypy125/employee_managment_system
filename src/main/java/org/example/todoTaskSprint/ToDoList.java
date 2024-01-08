package org.example.todoTaskSprint;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ToDoList {
//-----------------------------------------------------------region fill
    private List<Task> tasks;
//-----------------------------------------------------------region construction
    public ToDoList() {
        this.tasks = new ArrayList<>();
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

    private boolean isValidIndex(int index) {
        return index >= 0 && index < tasks.size();
    }
}
