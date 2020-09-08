package com.demo.Multithreading.Task.thirdVariant;

public class Producer implements Runnable {
    SharedTQ buffer;
    Producer(SharedTQ buffer){
        this.buffer = buffer;
    }
    @Override
    public void run() {
        for(int i = 1; i <= 100; i++){
            buffer.put(i);
        }
    }
}
