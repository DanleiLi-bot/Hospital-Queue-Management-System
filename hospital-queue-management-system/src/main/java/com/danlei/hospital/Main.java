package com.danlei.hospital;

import java.util.Scanner;

public class Main {
  public enum Gender {
    MALE("MALE"),
    FEMALE("FEMALE"),
    OTHER("OTHER");

    private final String name;

    Gender(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }
  }

  public enum Specialization {
    CARDIOLOGY("Cardiology", "Heart diseases"),
    DERMATOLOGY("Dermatology", "Skin conditions"),
    NEUROLOGY("Neurology", "Nervous system disorders"),
    PEDIATRICS("Pediatrics", "Children's health"),
    ORTHOPEDICS("Orthopedics", "Musculoskeletal system");

    private final String name;
    private final String description;

    Specialization(String name, String description) {
      this.name = name;
      this.description = description;
    }

    public String getName() {
      return name;
    }

    public String getDescription() {
      return description;
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String command = (scanner.nextLine()).trim().toLowerCase();

    QueueSystem queueSystem = new QueueSystem();
    if (command.equalsIgnoreCase("add patient")) {
      queueSystem.addPatient();
    } else if (command.equalsIgnoreCase("show queue")) {
      queueSystem.showQueue();
    } else if (command.equalsIgnoreCase("search patient")) {
      queueSystem.searchPatient();
    } else if (command.equalsIgnoreCase("call patient")) {
      queueSystem.callNextPatient();
    } else {
      System.out.println("Invalid command. Please enter a valid command.");
    }

    scanner.close();
  }
}
