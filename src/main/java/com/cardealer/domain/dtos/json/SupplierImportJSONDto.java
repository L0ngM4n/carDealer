package com.cardealer.domain.dtos.json;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created on 08/12/2016.
 */
public class SupplierImportJSONDto implements Serializable {

    @Expose
    private String name;

    @Expose
    private boolean isImporter;

    public SupplierImportJSONDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isImporter() {
        return isImporter;
    }

    public void setImporter(boolean importer) {
        isImporter = importer;
    }
}
