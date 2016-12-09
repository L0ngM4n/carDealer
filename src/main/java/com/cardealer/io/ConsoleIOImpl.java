package com.cardealer.io;


import com.cardealer.io.interfaces.ConsoleIO;
import org.springframework.stereotype.Component;

/**
 * Created on 06/12/2016.
 */
@Component
public class ConsoleIOImpl implements ConsoleIO {

    @Override
    public void write(String output) {
        System.out.println(output);
    }
}
