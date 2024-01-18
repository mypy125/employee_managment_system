package org.example.model.productBacklog;

import java.time.LocalDate;

public class BacklogItem {
//------------------------------------region fill
    private String itemName;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
//-------------------------------------------------------------------region constructor
    public BacklogItem(String itemName,String description, LocalDate startDate,LocalDate endDate) {
        this.itemName = itemName;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public BacklogItem() {
    }

    //--------------------------------------------------------region get and set
    public String getDescription() {
        return description;
    }

    public String getItemName() {
        return itemName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return "BacklogItem{" +
                "itemName='" + itemName + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
