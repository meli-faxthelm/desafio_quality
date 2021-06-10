package com.bootcamp.desafio_quality.model;

public class District {

    private String name;
    private double sqftPrice;

    public District() {
    }

    public District(String name, double sqftPrice) {
        this.name = name;
        this.sqftPrice = sqftPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSqftPrice() {
        return sqftPrice;
    }

    public void setSqftPrice(double sqftPrice) {
        this.sqftPrice = sqftPrice;
    }
}
