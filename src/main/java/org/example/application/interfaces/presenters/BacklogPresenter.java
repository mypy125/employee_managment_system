package org.example.application.interfaces.presenters;

import org.example.domain.backlog.Backlog;

import java.util.Collection;

public interface BacklogPresenter {
    void printAll(Collection<Backlog> backlog);
}
