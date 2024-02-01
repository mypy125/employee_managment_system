package org.example.domain.sprint;

import org.example.domain.Entity;

import java.time.LocalDate;

public class Sprint implements Entity {
//----------------------------------------------region fill
    private int id;
    private String description;
    private Priority priority;
    private LocalDate endDate;
    private boolean done;
//-----------------------------------------------------region construction
    public Sprint(int id, String description, Priority priority, LocalDate endDate){
        this.id = id;
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

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isDone() {
        return done;
    }
}
