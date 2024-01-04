package org.example.fileHandel;

import java.io.*;

public class FileHandler implements Writable{
    @Override
    public boolean saveToFile(Serializable serializable, String filePath) {
        try (ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(filePath))){
            objectOutput.writeObject(serializable);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object readFromFile(String filePath) {
        try (ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(filePath))){
            return objectInput.readObject();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
