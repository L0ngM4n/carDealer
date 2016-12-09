package com.cardealer.parser;

import com.cardealer.parser.interfaces.FileParser;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * Created on 07/12/2016.
 */
@Component(value = "XMLParser")
public class XMLParser implements FileParser {

    private JAXBContext jaxbContext;

    @Override
    @SuppressWarnings(value = "unchecked")
    public <T> T read(Class<T> classType, String fileName) throws IOException, JAXBException {
        this.jaxbContext = JAXBContext.newInstance(classType);
        Unmarshaller unmarshaller = this.jaxbContext.createUnmarshaller();
        T object;
        try (
                InputStream inputStream = getClass().getResourceAsStream(fileName);

        ) {
            object = (T) unmarshaller.unmarshal(inputStream);

        }
        return object;
    }

    @Override
    public <T> void write(T object, String fileName) throws JAXBException, FileNotFoundException {
        JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        OutputStream outputStream = new FileOutputStream(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        jaxbMarshaller.marshal(object, bufferedWriter);
    }
}