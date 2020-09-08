package com.demo.Multithreading.Task.thirdVariant;


import java.util.concurrent.*;

public class ThreadsTask {

    public static void main(String[] args) {
        // buffer class used by both threads
        SharedTQ buffer = new SharedTQ();
        // Starting three threads
        ExecutorService executor = Executors.newFixedThreadPool(3);
        // Executing producer
        executor.execute(new Producer(buffer));
        // Executing consumer
        executor.execute(new Consumer(buffer));
        executor.shutdown();
    }
}




