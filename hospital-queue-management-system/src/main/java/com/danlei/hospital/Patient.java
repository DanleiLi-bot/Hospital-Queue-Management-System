package com.danlei.hospital;

import com.danlei.hospital.Main.Gender;

public class Patient {
    private String name;
    private int age;
    private Gender gender;

    public Patient(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }
}
