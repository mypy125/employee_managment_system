package org.example.application.interfaces.context;

import org.example.domain.backlog.Backlog;
import org.example.domain.sprint.Sprint;

import java.util.Collection;

public interface SprintDatabaseContext {
    Collection<Sprint> getAllSprint();
    boolean saveChanges();
}
