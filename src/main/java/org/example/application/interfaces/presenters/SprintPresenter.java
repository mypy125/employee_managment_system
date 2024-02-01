package org.example.application.interfaces.presenters;

import org.example.domain.sprint.Sprint;

import java.util.Collection;

public interface SprintPresenter {
    void printAll(Collection<Sprint> sprints);
}
