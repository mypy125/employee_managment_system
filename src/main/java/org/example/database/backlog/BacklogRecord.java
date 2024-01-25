package org.example.database.backlog;

import java.time.LocalDate;

public class BacklogRecord {
    private static int counter;
    private int id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    public BacklogRecord(String name, String description) {
        this.name = name;
        this.description = description;
    }

    {
        id = ++counter;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        BacklogRecord.counter = counter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
