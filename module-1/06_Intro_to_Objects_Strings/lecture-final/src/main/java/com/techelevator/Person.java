package com.techelevator;

public class Person {

    private String name;
    private int age;
    private String email;

    public Person(int age, String name, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail(){
        return email;
    }
}
