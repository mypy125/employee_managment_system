package org.example.fileHandel;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface Writable {
    void saveToFile(String fileName, List<?> objects);
    Collection<Object> loadFromFile(String fileName);
}
