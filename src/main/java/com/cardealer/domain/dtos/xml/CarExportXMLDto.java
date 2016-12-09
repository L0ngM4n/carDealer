package com.cardealer.domain.dtos.xml;


import javax.xml.bind.annotation.*;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarExportXMLDto {

    @XmlAttribute(name = "make")
    private String make;

    @XmlElement(name = "model")
    private String model;

    @XmlElement(name = "mileage")
    private long travelledDistance;

    @XmlElementWrapper(name = "parts")
    @XmlElement(name = "part")
    private Set<PartExportXMLDto> parts;

    public CarExportXMLDto() {
        this.setParts(new HashSet<>());
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public Set<PartExportXMLDto> getParts() {
        return parts;
    }

    public void setParts(Set<PartExportXMLDto> parts) {
        this.parts = parts;
    }
}
