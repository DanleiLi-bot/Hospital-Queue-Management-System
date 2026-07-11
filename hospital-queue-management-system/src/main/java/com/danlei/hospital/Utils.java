package com.danlei.hospital;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.danlei.hospital.Main.Specialization;

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
}
