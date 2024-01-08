package org.example.productBacklog;

import org.example.productBacklog.BacklogItem;

import java.util.ArrayList;
import java.util.List;

public class ProductBacklog {
    private List<BacklogItem> backlogItems;

    public ProductBacklog() {
        this.backlogItems = new ArrayList<>();
    }

    public void addItem(BacklogItem item) {
        backlogItems.add(item);
    }

    public List<BacklogItem> getBacklogItems() {
        return backlogItems;
    }
}
