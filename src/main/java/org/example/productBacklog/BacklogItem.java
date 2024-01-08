package org.example.productBacklog;

import java.time.LocalDate;

public class BacklogItem {
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    public BacklogItem(String description, LocalDate startDate,LocalDate endDate) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }
}
