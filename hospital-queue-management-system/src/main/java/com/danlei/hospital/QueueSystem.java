package com.danlei.hospital;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import com.danlei.hospital.Main.Gender;

public class QueueSystem {
    List<Doctor> doctors = new ArrayList<>();
    Queue<Patient> patientQueue = new ArrayDeque<>();

    public QueueSystem() {
        loadDoctors();
    }

    private void loadDoctors() {
        // Implementation for loading doctors
        List<String> doctorData = Utils.readDoctors();
        for (String line : doctorData) {
            Doctor doctor = new Utils().parseDoctor(line);
            if (doctor != null) {
                doctors.add(doctor);
            }
        }
    }

    public void addPatient() {
        Patient patient = Utils.promptForPatient();
        if (patient != null) {
            patientQueue.add(patient);
            System.out.println("Patient added to the queue: " + patient.getName());
        } else {
            System.out.println("Failed to add patient.");
        }
    }

    public void showQueue(String patientName) {

    }

    public void searchPatient(String patientName) {

    }

    public void callNextPatient() {

    }

}
