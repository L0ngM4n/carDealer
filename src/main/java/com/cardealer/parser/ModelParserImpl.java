package com.cardealer.parser;


import com.cardealer.parser.interfaces.ModelParser;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ModelParserImpl implements ModelParser {

    private ModelMapper modelMapper;

    public ModelParserImpl() {
        this.modelMapper = new ModelMapper();
    }

    public <S, D> D convert(S source, Class<D> destinationType){
        D convertedObject = this.modelMapper.map(source, destinationType);
        return convertedObject;
    }

    public <S, D> D convert(S source, Class<D> destinationType, PropertyMap<S, D> propertyMap){
        this.modelMapper.addMappings(propertyMap);
        D convertedObject = this.modelMapper.map(source, destinationType);
        return convertedObject;
    }

    public <S, D> List<D> convert(List<S> soursList, Class<D> destinationType) {
        List<D> convertedList = new ArrayList<D>();
        soursList.forEach(s -> convertedList.add(this.modelMapper.map(s, destinationType)));
        return convertedList;
    }

    public <S, D> List<D> convert(List<S> soursList, Class<D> destinationType, PropertyMap<S, D> propertyMap) {
        this.modelMapper.addMappings(propertyMap);
        List<D> convertedList = new ArrayList<D>();
        soursList.forEach(s -> convertedList.add(this.modelMapper.map(s, destinationType)));
        return convertedList;
    }
}
