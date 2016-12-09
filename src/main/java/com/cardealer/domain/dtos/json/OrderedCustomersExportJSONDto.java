package com.cardealer.domain.dtos.json;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 09/12/2016.
 */
public class OrderedCustomersExportJSONDto implements Serializable{

    @Expose
    private long id;
    @Expose
    private String name;
    @Expose
    private String birthDate;
    @Expose
    private boolean isYoungDriver;
    @Expose
    private List<SaleExportJSONDto> sales;

    public OrderedCustomersExportJSONDto() {
        this.setSales(new ArrayList<>());
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }

    public List<SaleExportJSONDto> getSales() {
        return sales;
    }

    public void setSales(List<SaleExportJSONDto> sales) {
        this.sales = sales;
    }
}
