package com.techelevator;

public class Employee {

    private String name;
    private int age;
    private String email;

    public Employee(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }
}
