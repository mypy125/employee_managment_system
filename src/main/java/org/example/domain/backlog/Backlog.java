package org.example.domain.backlog;

import org.example.domain.Entity;

import java.time.LocalDate;

public class Backlog implements Entity {
//------------------------------------region fill

    private int id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
//-------------------------------------------------------------------region constructor

    public Backlog(int id, String name, String description, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }


    //--------------------------------------------------------region get and set


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public int getId() {
        return id;
    }
}
