package com.cardealer.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Basic
    @NotNull
    private String make;

    @Basic
    @NotNull
    private String model;

    @Column(name = "travelled_distance")
    private long travelledDistance;


    @ManyToMany
    @JoinTable(name = "cars_parts",
            joinColumns = @JoinColumn(name = "car_id"),
     inverseJoinColumns = @JoinColumn(name = "part_id"))
    private Set<Part> parts;

    public Car() {
        this.setParts(new HashSet<>());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public void setTravelledDistance(long traveledDistance) {
        this.travelledDistance = traveledDistance;
    }

    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }

    public void addPart(Part part) {
        this.getParts().add(part);
    }
}
