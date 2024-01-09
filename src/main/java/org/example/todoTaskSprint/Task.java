package org.example.todoTaskSprint;

import java.time.LocalDate;

public class Task {
//----------------------------------------------region fill
    private String description;
    private Priority priority;
    private LocalDate endDate;
    private boolean done;
//-----------------------------------------------------region construction
    public Task(String description,Priority priority,LocalDate endDate){
        this.description = description;
        this.priority = priority;
        this.endDate = endDate;
        this.done = false;
    }

    public void markAsDone() {
        this.done = true;
    }

    @Override
    public String toString() {
        return description + (done ? " (Done)" : "");
    }
//---------------------------------------------------region get and set
    public Priority getPriority() {
        return priority;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }
    public boolean isValidTask(Task task){
        return description != null && priority != null && endDate != null;
    }
}
