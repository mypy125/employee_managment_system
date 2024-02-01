package org.example.application;

import org.example.application.interfaces.SprintEditor;
import org.example.application.interfaces.context.SprintDatabaseContext;
import org.example.application.interfaces.presenters.SprintPresenter;
import org.example.domain.sprint.Sprint;

import java.util.Collection;
import java.util.Optional;

public class SprintEdit implements SprintEditor {
    private final SprintPresenter sprintPresenter;
    private final SprintDatabaseContext databaseContext;
    public SprintEdit(SprintPresenter sprintPresenter,
                      SprintDatabaseContext databaseContext){
        this.sprintPresenter = sprintPresenter;
        this.databaseContext = databaseContext;
    }

    @Override
    public void printAll() {
        sprintPresenter.printAll(getAll());
    }
    @Override
    public boolean add(Sprint item) {
        databaseContext.getAllSprint().add(item);
        return databaseContext.saveChanges();
    }

    @Override
    public boolean edit(Sprint item) {
        if(item == null)
            return false;
        Optional<Sprint> sprint = getById(item.getId());
        if(sprint.isEmpty())
            return false;
        sprint.get().setId(item.getId());
        sprint.get().setDescription(item.getDescription());
        sprint.get().setDone(item.isDone());
        sprint.get().setPriority(item.getPriority());
        sprint.get().setEndDate(item.getEndDate());
        return databaseContext.saveChanges();
    }

    @Override
    public boolean remove(Sprint item) {
        databaseContext.getAllSprint().remove(item);
        return databaseContext.saveChanges();
    }

    @Override
    public Optional<Sprint> getById(Integer integer) {
        return databaseContext.getAllSprint().stream().filter(s -> s.getId() == integer).findFirst();
    }

    @Override
    public Collection<Sprint> getAll() {
        return databaseContext.getAllSprint();
    }


}
