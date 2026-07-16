package com.danlei.hospital;

import com.danlei.hospital.Main.Gender;
import com.danlei.hospital.Main.Specialization;

public class Patient {
    private String name;
    private int age;
    private Gender gender;
    private Specialization symptom;
    private Doctor assignedDoctor = null;

    public Patient(String name, int age, Gender gender, Specialization symptom) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.symptom = symptom;
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

    public Specialization getSymptom() {
        return symptom;
    }

    public Doctor getAssignedDoctor() {
        return assignedDoctor;
    }

    public void setAssignedDoctor(Doctor doctor) {
        this.assignedDoctor = doctor;
    }
}
