package org.example.productBacklog;

import org.example.productBacklog.BacklogItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductBacklog extends BacklogItem{
    private List<BacklogItem> backlogItems;

    public ProductBacklog(){
        this.backlogItems =  new ArrayList<>();
    }
    public ProductBacklog(String itemName, String description, LocalDate startDate, LocalDate endDate) {
        super(itemName,description, startDate,endDate);
        this.backlogItems = new ArrayList<>();
    }

    public void addItem(BacklogItem item) {
        backlogItems.add(item);
    }

    public List<BacklogItem> getBacklogItems() {
        return backlogItems;
    }

}
