package com.cardealer.domain.dtos.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;

/**
 * Created on 09/12/2016.
 */

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsExportXMLDto {

    @XmlElement(name = "car")
    private Set<CarExportXMLDto> cars;

    public CarsExportXMLDto() {
        this.setCars(new HashSet<>());
    }

    public Set<CarExportXMLDto> getCars() {
        return cars;
    }

    public void setCars(Set<CarExportXMLDto> cars) {
        this.cars = cars;
    }
}
