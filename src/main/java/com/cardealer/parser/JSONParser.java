package com.cardealer.parser;

import com.cardealer.io.interfaces.FileIO;
import com.cardealer.parser.interfaces.FileParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component(value = "JSONParser")
public class JSONParser implements FileParser {

    private Gson gson;

    @Autowired
    private FileIO fileIO;

    public JSONParser() {
        this.gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")//"1993-11-20T00:00:00"
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }

    @Override
    public <T> T read(Class<T> classType, String fileName) throws IOException {
        String jsonContent = this.fileIO.read(fileName);
        T convertedObject = gson.fromJson(jsonContent, classType);

        return convertedObject;
    }

    @Override
    public <T> void write(T object, String file) throws IOException {
        String jsonContent = this.gson.toJson(object);

        this.fileIO.write(jsonContent, file);
    }
}
