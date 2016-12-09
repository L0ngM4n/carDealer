package com.cardealer.domain.dtos.json;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

/**
 * Created on 09/12/2016.
 */
public class PartExportJSONDto {

    @Expose
    private String name;
    @Expose
    private BigDecimal price;

    public PartExportJSONDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
