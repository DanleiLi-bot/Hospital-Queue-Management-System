package com.danlei.hospital;
import java.util.List;

import com.danlei.hospital.Main.Gender;

public class QueueSystem {
    public QueueSystem() {
        loadDoctors();
    }

    private void loadDoctors() {
        // Implementation for loading doctors
        List<String> doctorData = Utils.readDoctors();
    }

    public void addPatient(String name, int age, Gender gender) {

    }

    public void showQueue(String patientName) {

    }

    public void searchPatient(String patientName) {

    }

    public void callNextPatient() {

    }

}
