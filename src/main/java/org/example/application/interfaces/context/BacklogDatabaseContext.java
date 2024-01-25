package org.example.application.interfaces.context;

import org.example.domain.backlog.Backlog;

import java.util.Collection;

public interface BacklogDatabaseContext {
    Collection<Backlog> getAllBacklog();
    boolean saveChanges();
}
