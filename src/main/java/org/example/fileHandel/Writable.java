package org.example.fileHandel;

import java.io.Serializable;
import java.util.Collection;

public interface Writable {
    void saveToFile(String fileName, Collection<Object> objects);
    Collection<Object> loadFromFile(String fileName);
}
