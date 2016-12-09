package com.cardealer.domain.dtos.xml;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartExportXMLDto {

    @XmlAttribute(name = "name")
    private String name;
    @XmlElement(name = "price")
    private BigDecimal price;

    @XmlElement(name = "quantity")
    private int quantity;

    public PartExportXMLDto() {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
