package com.demo.Multithreading.Task.thirdVariant;

import java.util.concurrent.BlockingQueue;

public class Incrementer implements Runnable {

    private final BlockingQueue<Integer> incomingQueue;
    private final BlockingQueue<Integer> outcomingQueue;

    public Incrementer(BlockingQueue<Integer> incomingQueue, BlockingQueue<Integer> outcomingQueue) {
        this.incomingQueue = incomingQueue;
        this.outcomingQueue = outcomingQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer incrementer = incomingQueue.take();
                System.out.println(Thread.currentThread().getName() + " took " + incrementer);
                if (incrementer == 100) {
                    outcomingQueue.put(incrementer);
                    break;
                } else {
                    outcomingQueue.put(incrementer + 1);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
