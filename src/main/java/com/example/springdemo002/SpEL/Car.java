package com.example.springdemo002.SpEL;

//SpEL相关

public class Car {
    private String brand;
    private String Model;
    private Integer maxSpeed;
    //轮胎的周长
    private Double tyrePemimeter;

    public Car() {
    }

    public Car(String brand, String model, Integer maxSpeed) {
        this.brand = brand;
        Model = model;
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Double getTyrePemimeter() {
        return tyrePemimeter;
    }

    public void setTyrePemimeter(Double tyrePemimeter) {
        this.tyrePemimeter = tyrePemimeter;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", Model='" + Model + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", tyrePemimeter=" + tyrePemimeter +
                '}';
    }
}
