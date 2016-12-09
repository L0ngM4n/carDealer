package com.cardealer.domain.dtos.json;

import com.google.gson.annotations.Expose;

import java.io.Serializable;


public class SaleExportJSONDto implements Serializable {

    @Expose
    private long id;

    @Expose
    private String discount;

    public SaleExportJSONDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}
