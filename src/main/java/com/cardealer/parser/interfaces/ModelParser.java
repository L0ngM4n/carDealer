package com.cardealer.parser.interfaces;


import org.modelmapper.PropertyMap;

import java.util.List;

/**
 * Created on 06/12/2016.
 */
public interface ModelParser {

    <S, D> D convert(S source, Class<D> destinationClass);

    <S, D> D convert(S source, Class<D> destinationClass, PropertyMap<S, D> propertyMap);

    <S, D> List<D> convert(List<S> soursList, Class<D> destinationType);

    <S, D> List<D> convert(List<S> soursList, Class<D> destinationType, PropertyMap<S, D> propertyMap);
}
