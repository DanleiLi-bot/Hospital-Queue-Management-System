package com.danlei.hospital;

public class Doctor {
    private String name;
    private String specialization;
    private String availability;
    private String roomNumber;

    public Doctor(String name, String specialization, String availability, String roomNumber) {
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
        this.roomNumber = roomNumber;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getAvailability() {
        return availability;
    }

    public String getRoomNumber() {
        return roomNumber;
    }
}
