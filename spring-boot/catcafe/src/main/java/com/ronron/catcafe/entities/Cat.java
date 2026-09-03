package com.ronron.catcafe.entities;

public class Cat {

    private String name, biography;
    private int age;

    public Cat(String name, String biography, int age) {
        this.name = name;
        this.biography = biography;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
