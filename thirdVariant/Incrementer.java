package com.demo.Multithreading.Task.thirdVariant;

import java.util.concurrent.BlockingQueue;

public class Incrementer implements Runnable {


    private final BlockingQueue<Integer> incomingQueue;
    private final BlockingQueue<Integer> outcomingQueue;

    static volatile int i = 0;
    static boolean stop = false;

    public Incrementer(BlockingQueue<Integer> incomingQueue,
                       BlockingQueue<Integer> outcomingQueue) {
        this.incomingQueue = incomingQueue;
        this.outcomingQueue = outcomingQueue;
    }


    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(Thread.currentThread().getName() + " took " + i);
                if (stop) {
                    outcomingQueue.put(incomingQueue.take());
                    break;
                } else if (i != 100) {
                    i++;
                } else {
                    stop = true;
                }
                System.out.println(Thread.currentThread().getName() + " sent " + i);
                outcomingQueue.put(incomingQueue.take());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
