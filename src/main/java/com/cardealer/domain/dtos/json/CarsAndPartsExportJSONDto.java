package com.cardealer.domain.dtos.json;


import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.List;

public class CarsAndPartsExportJSONDto implements Serializable {

    @Expose
    private String make;

    @Expose
    private String model;

    @Expose
    private long travelledDistance;

    @Expose
    private List<PartExportJSONDto> parts;

    public CarsAndPartsExportJSONDto() {
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

    public List<PartExportJSONDto> getParts() {
        return parts;
    }

    public void setParts(List<PartExportJSONDto> parts) {
        this.parts = parts;
    }
}
