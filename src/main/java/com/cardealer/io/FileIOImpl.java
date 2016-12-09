package com.cardealer.io;


import com.cardealer.io.interfaces.FileIO;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * Created on 06/12/2016.
 */
@Component
public class FileIOImpl implements FileIO {

    @Override
    public String read(String filePath) throws IOException {
        StringBuilder fileContent = new StringBuilder();
        try(
                InputStream is = getClass().getResourceAsStream(filePath);
                BufferedReader bfr = new BufferedReader(new InputStreamReader(is));
                ) {
            String line = null;

            while ((line = bfr.readLine()) != null) {
                fileContent.append(line);
            }
        }

        return fileContent.toString();
    }

    @Override
    public void write(String fileContent, String filePath) throws IOException {
        try(
                OutputStream outputStream  = new FileOutputStream(filePath);
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
                ) {
            bufferedWriter.write(fileContent);
        }

    }
}
