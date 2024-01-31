package org.example.application;

import org.example.application.interfaces.BacklogEditor;
import org.example.application.interfaces.context.BacklogDatabaseContext;
import org.example.application.interfaces.presenters.BacklogPresenter;
import org.example.domain.backlog.Backlog;
import org.example.domain.employee.Employee;

import java.util.Collection;
import java.util.Optional;

public class BacklogEdit implements BacklogEditor {
    private final BacklogDatabaseContext databaseContext;
    private final BacklogPresenter backlogPresenter;

    public BacklogEdit(BacklogPresenter backlogPresenter,
                       BacklogDatabaseContext databaseContext) {
        this.backlogPresenter = backlogPresenter;
        this.databaseContext = databaseContext;
    }
    @Override
    public void printAll() {
        backlogPresenter.printAll(getAll());
    }

    @Override
    public boolean add(Backlog item) {
        databaseContext.getAllBacklog().add(item);
        return databaseContext.saveChanges();
    }

    @Override
    public boolean edit(Backlog item) {
        if(item == null)
            return false;
        Optional<Backlog> backlog = getById(item.getId());
        if(backlog.isEmpty())
            return false;
        backlog.get().setId(item.getId());
        backlog.get().setName(item.getName());
        backlog.get().setDescription(item.getDescription());
        backlog.get().setStartDate(item.getStartDate());
        backlog.get().setEndDate(item.getEndDate());
        return databaseContext.saveChanges();
    }

    @Override
    public boolean remove(Backlog item) {
        databaseContext.getAllBacklog().remove(item);
        return databaseContext.saveChanges();
    }

    @Override
    public Optional<Backlog> getById(Integer integer) {
       return databaseContext.getAllBacklog().stream().filter(p -> p.getId() == integer).findFirst();
    }

    @Override
    public Collection<Backlog> getAll() {
        return databaseContext.getAllBacklog();
    }


}
