package com.danlei.hospital;

import java.util.Scanner;

public class Main {
    public enum Gender {
        MALE("MALE"), FEMALE("FEMALE"), OTHER("OTHER");
        
        private final String name;

        Gender(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public enum Specialization {
        CARDIOLOGY("Cardiology"), DERMATOLOGY("Dermatology"), NEUROLOGY("Neurology"), PEDIATRICS("Pediatrics"), ORTHOPEDICS("Orthopedics");
        
        private final String name;

        Specialization(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = (scanner.nextLine()).trim().toLowerCase();
        scanner.close();    
    }
}