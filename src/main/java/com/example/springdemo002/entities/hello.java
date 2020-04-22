package com.example.springdemo002.entities;

public class hello {
    private String name;

    public hello() {
    }

    public void helloWorld(){
        System.out.println("hello " + name);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "hello{" +
                "name='" + name + '\'' +
                '}';
    }
}
