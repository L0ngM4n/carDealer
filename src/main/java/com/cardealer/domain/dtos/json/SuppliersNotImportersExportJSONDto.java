package com.cardealer.domain.dtos.json;


import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class SuppliersNotImportersExportJSONDto implements Serializable {

    @Expose
    private long id;

    @Expose
    private String name;

    @Expose
    private long partsCount;

    public SuppliersNotImportersExportJSONDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPartsCount() {
        return partsCount;
    }

    public void setPartsCount(long partsCount) {
        this.partsCount = partsCount;
    }
}
