package org.example.application;

import org.example.application.interfaces.BacklogEditor;
import org.example.application.interfaces.context.BacklogDatabaseContext;
import org.example.domain.backlog.Backlog;

import java.util.Collection;
import java.util.Optional;

public class BacklogEdit implements BacklogEditor {
    private BacklogDatabaseContext databaseContext;

    public BacklogEdit(BacklogDatabaseContext databaseContext) {
        this.databaseContext = databaseContext;
    }

    @Override
    public boolean add(Backlog item) {
        return false;
    }

    @Override
    public boolean edit(Backlog item) {
        return false;
    }

    @Override
    public boolean remove(Backlog item) {
        return false;
    }

    @Override
    public Optional<Backlog> getById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Collection<Backlog> getAll() {
        return null;
    }
}
