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
            for (Doctor doctor : doctors) {
                if (doctor.getSpecialization() == patient.getSymptom() && doctor.isAvailable()) {
                    patient.setAssignedDoctor(doctor);
                    doctor.setAvailability(false);
                    break;
                }
            }
            System.out.println("Patient added to the queue: " + patient.getName());
        } else {
            System.out.println("Failed to add patient.");
            return;
        }
    }

    public void showQueue() {
        String patientName = Utils.scanner.nextLine().trim();
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
            System.out.println("There are " + number + " patients ahead of " + patientName);
        } else {
            System.out.println("Patient not found in queue.");
        }
    }

    public void searchPatient() {
        String patientName = Utils.scanner.nextLine().trim();
        if (patientName == null || patientName.isEmpty()) {
            System.out.println("Invalid patient name.");
            return;
        } else if (patientQueue.isEmpty()) {
            System.out.println("The queue is currently empty.");
            return;
        }

        boolean found = false;
        Patient foundPatient = null;
        for (Patient patient : patientQueue) {
            if (patient.getName().equalsIgnoreCase(patientName)) {
                found = true;
                foundPatient = patient;
                break;
            }
        }
        if (found) {
            System.out.println("Patient " + patientName + " is in the queue.");
            StringBuilder sb = new StringBuilder();
            sb.append(foundPatient.getName())
             .append(" (Age: ")
             .append(foundPatient.getAge())
             .append(")");
            System.out.println(sb.toString());
        } else {
            System.out.println("Patient " + patientName + " is not in the queue.");
        }

    }

    public void callNextPatient() {
        Patient nextPatient = patientQueue.poll();
        if (nextPatient != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calling patient: ")
              .append(nextPatient.getName())
              .append("To room: ")
              .append(nextPatient.getAssignedDoctor().getRoomNumber());
            System.out.println(sb.toString());
            nextPatient.getAssignedDoctor().setAvailability(true);
        } else {
            System.out.println("No patients in the queue.");
        }
    }

}
