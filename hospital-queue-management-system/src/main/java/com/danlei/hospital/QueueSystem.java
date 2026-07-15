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
        if (patientName == null || patientName.isEmpty()) {
            System.out.println("Invalid patient name.");
            return;
        } else if (patientQueue.isEmpty()) {
            System.out.println("The queue is currently empty.");
            return;
        }

        Patient foundPatient = null;
        int number = 0;
        for (Patient patient : patientQueue) {
            number++;
            if (patient.getName().equalsIgnoreCase(patientName)) {
                foundPatient = patient;
                break;
            }
        }
        if (foundPatient != null) {
            number = number - 1; // Adjusting for zero-based index
            System.out.println("Patient found in queue at position " + number);
        } else {
            System.out.println("Patient not found in queue.");
        }
    }

    public void searchPatient(String patientName) {

    }

    public void callNextPatient() {

    }

}
