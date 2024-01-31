package org.example.presentation.qeries.controllers;

import org.example.application.interfaces.BacklogEditor;
import org.example.domain.backlog.Backlog;

public class BacklogController extends Controller{
    private final BacklogEditor backlogEditor;
    public BacklogController(BacklogEditor backlogEditor){
        this.backlogEditor = backlogEditor;
    }

    void routAddBacklog(Backlog backlog){
        this.backlogEditor.add(backlog);
    }
    void routRemoveBacklog(Backlog backlog){
        this.backlogEditor.remove(backlog);
    }
    void routGetaAll(){
        backlogEditor.printAll();
    }
}
