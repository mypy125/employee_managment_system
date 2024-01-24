package org.example.application;

import org.example.application.interfaces.SprintEditor;
import org.example.domain.sprint.Sprint;

import java.util.Collection;
import java.util.Optional;

public class SprintEdit implements SprintEditor {
    @Override
    public boolean add(Sprint item) {
        return false;
    }

    @Override
    public boolean edit(Sprint item) {
        return false;
    }

    @Override
    public boolean remove(Sprint item) {
        return false;
    }

    @Override
    public Optional<Sprint> getById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Collection<Sprint> getAll() {
        return null;
    }
}
