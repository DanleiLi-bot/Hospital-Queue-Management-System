package com.danlei.hospital;

import com.danlei.hospital.Main.Specialization;

public class Doctor {
    private String name;
    private Specialization specialization;
    private String availability = "yes";
    private String roomNumber;

    public Doctor(String name, Specialization specialization, String roomNumber) {
        this.name = name;
        this.specialization = specialization;
        this.roomNumber = roomNumber;
    }

    public String getName() {
        return name;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public String getAvailability() {
        return availability;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}
