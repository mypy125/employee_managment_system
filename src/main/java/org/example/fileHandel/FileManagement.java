package org.example.fileHandel;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FileManagement implements Writable{
    public static final String FILE_JSON = "file.json";
    public static final String FILE_XML = "file.xml";
    public static final String FILE_BIN = "file.bin";
    public static final ObjectMapper objectMapper = new ObjectMapper();
    public static final XmlMapper xmlMapper = new XmlMapper();


    @Override
    public void saveToFile(String fileName, List<?> objects) {

        try {
            if (fileName.endsWith(".json")) {
                objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                objectMapper.writeValue(new File(fileName), objects);
            }
            else if (fileName.endsWith(".bin")){
                try ( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
                    oos.writeObject(objects);
                }
            }
            else if (fileName.endsWith(".xml")) {
                xmlMapper.configure(SerializationFeature.INDENT_OUTPUT,true);
                xmlMapper.writeValue(new File(fileName), objects);
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public Collection<Object> loadFromFile(String fileName) {
        Collection<Object> objects = new ArrayList<>();
        File file = new File(fileName);

        if(file.exists()) {
            try {
                if(fileName.endsWith(".json")){
                    objects = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Object.class));
                }
                else if (fileName.endsWith(".bin")){
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                        objects = (Collection<Object>)ois.readObject();
                    }
                }
                else if (fileName.endsWith(".xml")) {
                    objects = xmlMapper.readValue(file, xmlMapper.getTypeFactory().constructCollectionType(List.class, Object.class));
                }

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return objects;
    }


}
