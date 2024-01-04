package org.example;

import java.time.LocalDate;

public class Sprint {
//----------------------------------------------region fill
    private String name;
    private String Sprint;
    private LocalDate startDate;
    private LocalDate endDate;
    //-----------------------------------------------------------region construction
    public Sprint(String name, String sprint, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.Sprint = sprint;
        this.startDate = startDate;
        this.endDate = endDate;
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

}
