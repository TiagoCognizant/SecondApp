package com.example.javaexample.multithreading;

public class Demo {

    public static void main(String[] args) {
        FeeThread feeThread = new FeeThread();
        feeThread.start();

        LibraryThread libraryThread = new LibraryThread();
        Thread libThread = new Thread(libraryThread);
        libThread.start();
    }



}
