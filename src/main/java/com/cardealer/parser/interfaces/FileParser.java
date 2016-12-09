package com.cardealer.parser.interfaces;

import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * Created on 06/12/2016.
 */
public interface FileParser {
    <T> T read(Class<T> classType, String fileName) throws IOException, JAXBException;

    <T> void write(T object, String file) throws IOException, JAXBException;
}
