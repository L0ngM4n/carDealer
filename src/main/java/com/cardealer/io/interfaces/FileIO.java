package com.cardealer.io.interfaces;

import java.io.IOException;

/**
 * Created on 06/12/2016.
 */
public interface FileIO {

    String read(String filePath) throws IOException;

    void write(String fileContent, String filePath) throws IOException;
}
