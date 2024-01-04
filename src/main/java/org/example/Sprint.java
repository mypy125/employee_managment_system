package org.example;

import java.time.LocalDate;

public class Sprint {
//----------------------------------------------region fill
    private String name;
    private String Sprint;
    private LocalDate startDate;
    private LocalDate endDate;
    private Priority priority;
    //-----------------------------------------------------------region construction
    public Sprint(String name, String sprint, LocalDate startDate, LocalDate endDate,Priority priority) {
        this.name = name;
        this.Sprint = sprint;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priority = priority;
    }
//----------------------------------------------region get and set
    public String getName() {
        return name;
    }

    public String getSprint() {
        return Sprint;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Priority getPriority() {
        return priority;
    }
}
