package com.example.demo;

public class Dog {
    private int id;
    private String breed;
    private int age;
    private String image_url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Dog(int id, String breed, int age, String image_url) {
        this.id = id;
        this.breed = breed;
        this.age = age;
        this.image_url = image_url;
    }
}
