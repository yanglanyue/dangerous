package com.example.springdemo002.entities;

public class person {

    private String name;
    private Integer age;
    private String gender;
    private Car car;
    private Object spouse;

    public person() {
    }

    public person(String name, Integer age, String gender, Car car) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.car = car;
    }

    public person(String name, Integer age, String gender, Car car, Object spouse) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.car = car;
        this.spouse = spouse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Object getSpouse() {
        return spouse;
    }

    public void setSpouse(Object spouse) {
        this.spouse = spouse;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", car=" + car +
                ", spouse=" + spouse +
                '}';
    }
}
