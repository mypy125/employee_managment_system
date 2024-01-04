package org.example.fileHandel;

import java.io.Serializable;

public interface Writable {
    boolean saveToFile(Serializable serializable, String filePath);
    Object readFromFile(String path);
}
