package com.danlei.hospital;

public class InvalidSymptomException extends Exception {
    public InvalidSymptomException(String symptom) {
        super("Invalid symptom: " + symptom);
    }
}
