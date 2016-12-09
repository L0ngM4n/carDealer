package com.cardealer.domain.dtos.json;


import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.Date;

public class CustomerImportJSONDto  implements Serializable{

    @Expose
    private String name;
    @Expose
    private Date birthDate; //":"1993-11-20T00:00:00",
    @Expose
    private Boolean isYoungDriver;

    public CustomerImportJSONDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(Boolean youngDriver) {
        isYoungDriver = youngDriver;
    }
}
