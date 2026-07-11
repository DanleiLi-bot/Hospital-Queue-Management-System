package com.danlei.hospital;

import java.util.Scanner;

public class Main {
    public enum Gender {
        MALE, FEMALE, OTHER;
    }

    public enum Specialization {
        CARDIOLOGY, DERMATOLOGY, NEUROLOGY, PEDIATRICS, ORTHOPEDICS;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = (scanner.nextLine()).trim().toLowerCase();
        scanner.close();    
    }
}