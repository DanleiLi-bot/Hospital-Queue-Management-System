package com.danlei.hospital;

import com.danlei.hospital.Main.Specialization;

public class Doctor {
    private String name;
    private Specialization specialization;
    private boolean isAvailable = true;
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

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setAvailability(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
