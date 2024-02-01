package org.example.presentation.qeries.controllers;

import org.example.application.interfaces.SprintEditor;
import org.example.domain.sprint.Sprint;

public class SprintController extends Controller {
    private final SprintEditor sprintEditor;
    public SprintController(SprintEditor sprintEditor){
        this.sprintEditor = sprintEditor;
    }


    void routAddSprint(Sprint sprint){
        this.sprintEditor.add(sprint);
    }

    void routRemoveSprint(Sprint sprint){
        sprintEditor.remove(sprint);
    }
    void routGetAll(){

    }
}
