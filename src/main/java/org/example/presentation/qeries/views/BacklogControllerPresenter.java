package org.example.presentation.qeries.views;

import org.example.application.interfaces.presenters.BacklogPresenter;
import org.example.domain.backlog.Backlog;

import java.util.Collection;

public class BacklogControllerPresenter implements BacklogPresenter {
    @Override
    public void printAll(Collection<Backlog> backlogs) {
        for (Backlog backlog : backlogs){
            System.out.println(backlog.getId());
        }
    }
}
