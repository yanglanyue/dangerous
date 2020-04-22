package com.example.springdemo002.SpEL;


import java.util.List;

public class person {

    private String name;
    private Integer age;
    private String gender;
    private Car car;
    private List<person> spouseList;

    //引用address bean的city属性
    private String city;
    //根据car的brand判断车主是屌丝还是高富帅
    private String info;

    public person() {
    }

    public person(String name, Integer age, String gender, Car car) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.car = car;
    }

    public person(String name, Integer age, String gender, List<Car> carList, List<person> personList) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.car = car;
        this.spouseList = personList;
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

    public List<person> getPersonList() {
        return spouseList;
    }

    public void setPersonList(List<person> personList) {
        this.spouseList = personList;
    }

    public List<person> getSpouseList() {
        return spouseList;
    }

    public void setSpouseList(List<person> spouseList) {
        this.spouseList = spouseList;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", car=" + car +
                ", spouseList=" + spouseList +
                ", city='" + city + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
