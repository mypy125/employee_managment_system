package org.example.presentation.qeries.views;

import org.example.application.interfaces.presenters.SprintPresenter;
import org.example.domain.sprint.Sprint;

import java.util.Collection;

public class SprintControllerPresenter implements SprintPresenter {
    @Override
    public void printAll(Collection<Sprint> sprints) {
        for(Sprint sprint: sprints){
            System.out.println(sprint.getId());
        }
    }
}
