package com.example.javaexample.multithreading;

public class LibraryThread implements Runnable{

    @Override
    public void run() {
        System.out.println("Im getting signs from library");
    }
}
