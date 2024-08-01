package com.example.javaexample.interfaces;

public class Biticino  implements ISwitchBoardListener{ // ex: switch supplier

    @Override
    public void switchOne() {
        System.out.println("Biticino fan is on");

    }

    @Override
    public void switchTwo() {
        System.out.println("Biticino light is on");
    }

    @Override
    public void switchThree() {
        System.out.println("Biticino AC is on");
    }
}
