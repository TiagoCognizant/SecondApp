package com.example.javaexample.multithreading;

public class FeeThread extends Thread{

    @Override
    public void run() {
        super.run();
        System.out.println("fee dept sign -- no dues");
    }
}
