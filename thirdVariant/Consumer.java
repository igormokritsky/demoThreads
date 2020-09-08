package com.demo.Multithreading.Task.thirdVariant;

public class Consumer implements Runnable {
    SharedTQ buffer;
    Consumer(SharedTQ buffer){
        this.buffer = buffer;
    }
    @Override
    public void run() {
        for(int i = 1; i <= 100; i++){
            buffer.get();
        }
    }
}
