package com.danlei.hospital;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.danlei.hospital.Main.Specialization;
import com.danlei.hospital.Main.Gender;

public class Utils {
    public static Scanner scanner = new Scanner(System.in);

    public static List<String> readDoctors() {
        return readCsv("./src/main/resources/doctors.csv");
    }

    /**
   * read the content of a csv file.
   *
   * @param fileName of the csv file
   * @return a list of String, where each element is a line in the CSV file
   */
  private static List<String> readCsv(String fileName) {
    List<String> result = new LinkedList<>();
    // reading the file
    String line;
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
      while ((line = br.readLine()) != null) {
        result.add(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return result;
  }

  public Doctor parseDoctor(String line) {
        String[] parts = line.trim().split(",");
        String name = parts[0].trim();
        String specializationStr = parts[1].trim();
        String roomNumber = parts[2].trim();

        Specialization thisSpec = null;
        for (Specialization spec : Specialization.values()) {
            if (spec.getName().equalsIgnoreCase(specializationStr)) {
                thisSpec = spec;
                break;
            }
        }

        if (thisSpec != null && !roomNumber.isEmpty()) {
            return new Doctor(name, thisSpec, roomNumber);
        }
        return null;
    }

    public static Patient promptForPatient() {

      while (true) {
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter patient age: ");
        int age;
        try {
            age = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid age. Please enter a valid number.");
            continue;
        }

        System.out.print("Enter patient gender (MALE/FEMALE/OTHER): ");
        String genderStr = scanner.nextLine().trim().toUpperCase();
        Gender thisGender = null;
        try {
          for (Gender gender : Gender.values()) {
            if (gender.getName().equals(genderStr)) {
              thisGender = gender;
              break;
            }
          }
          if (thisGender == null) {
            throw new InvalidGenderException(genderStr);
          }
        } catch (InvalidGenderException e) {
          System.out.println(e.getMessage());
        }

        System.out.println("Select which symptom the patient has(CARDIOLOGY/DERMATOLOGY/NEUROLOGY/PEDIATRICS/ORTHOPEDICS):");
        String symptomStr = scanner.nextLine().trim().toUpperCase();
        Specialization thisSymptom = null;
        
        try {
          for (Specialization symptom : Specialization.values()) {
            if (symptom.getName().equals(symptomStr)) {
              thisSymptom = symptom;
              Patient patient = new Patient(name, age, thisGender, thisSymptom);
              return patient;
            }
          }
          if (thisSymptom == null) {
            throw new InvalidSymptomException(symptomStr);
          }
        } catch (InvalidSymptomException e) {
          System.out.println(e.getMessage());
        }

        return null; // This line will never be reached, but is required to satisfy the method's return type.
        
      }

    }
}
