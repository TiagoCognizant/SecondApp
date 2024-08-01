package com.example.javaexample;

import com.example.javaexample.interfaces.Biticino;
import com.example.javaexample.interfaces.GEAppliances;
import com.example.javaexample.interfaces.ISwitchBoardListener;

public class MyClass {

    public static void main(String[] args) {

        ISwitchBoardListener isbl = new Biticino();
                //new GEAppliances(); //wiring

        //me clicking the switches
        isbl.switchOne();
        isbl.switchTwo();
        isbl.switchThree();

    }
}
