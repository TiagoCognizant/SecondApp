package com.example.javaexample;

public class Pen {

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("gc execute this before ");
    }

}
