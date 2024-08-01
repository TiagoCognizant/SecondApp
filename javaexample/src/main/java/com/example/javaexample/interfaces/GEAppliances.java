package com.example.javaexample.interfaces;

public class GEAppliances implements ISwitchBoardListener {

    @Override
    public void switchOne() {
        System.out.println("GE fan is on");
    }

    @Override
    public void switchTwo() {
        System.out.println("GE light is on");
    }

    @Override
    public void switchThree() {
        System.out.println("GE AC is on");
    } // Switch Suppliers




}
