package com.danlei.hospital;

public class InvalidGenderException extends Exception{

    public InvalidGenderException(String gender) {
        super("Invalid gender: " + gender);
    }
}
