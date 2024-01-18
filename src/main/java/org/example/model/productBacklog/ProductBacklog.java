package org.example.model.productBacklog;

import org.example.model.productBacklog.BacklogItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductBacklog extends BacklogItem {
    private List<BacklogItem> backlogItems;
    private BacklogItem backlogItem;
    public ProductBacklog(BacklogItem backlogItem){
        this.backlogItem = backlogItem;
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
