package org.example.database.sprint;

import org.example.domain.sprint.Priority;

import java.time.LocalDate;

public class SprintRecord {
    private static int counter;
    private int id;
    private String description;
    private Priority priority;
    private LocalDate endDate;
    private boolean done;

    public SprintRecord(String description, Priority priority) {
        this.description = description;
        this.priority = priority;
    }

    {
        id = ++counter;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

}
