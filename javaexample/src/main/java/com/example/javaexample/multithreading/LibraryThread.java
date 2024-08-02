package com.example.javaexample.multithreading;

public class LibraryThread implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(500);
            for(int i=1;i<6;i++){
                System.out.println(Thread.currentThread().getName()+"--"+i*10);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
