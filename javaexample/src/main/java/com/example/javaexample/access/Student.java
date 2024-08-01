package com.example.javaexample.access;

public class Student {

    private String penPocket; // Private you cannot access directly

    // Access to pen through this method
    public String getPen() {
        return this.penPocket;
    }

    public void putPenPocket(String pen){
        penPocket = pen;
    }



}
