package com.demo.Multithreading.Task.firstVariant;

import java.util.concurrent.atomic.AtomicInteger;

public class Worker extends Thread {
    private final ResourceLock resourceLock;
    private final int threadNumber;
    private final AtomicInteger counter;
    private static final int limit = 100;
    public Worker(ResourceLock resourceLock, int threadNumber, AtomicInteger counter) {
        this.resourceLock = resourceLock;
        this.threadNumber = threadNumber;
        this.counter = counter;
    }

    @Override
    public void run() {
        while (counter.get() < limit - 2) {
            try {
                synchronized (resourceLock) {
                    while (resourceLock.flag != threadNumber) {
                        resourceLock.wait();
                    }
                    System.out.println("Thread:" + threadNumber + " value: " + counter.incrementAndGet());
                    resourceLock.flag = (threadNumber + 1) % resourceLock.threadsCount;
                    resourceLock.notifyAll();
                }
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
    }


    public static void main(String[] args) {
        final int threadsCount = 3;
        final ResourceLock lock = new ResourceLock(threadsCount);
        Worker[] threads = new Worker[threadsCount];
        final AtomicInteger counter = new AtomicInteger(0);
        for(int i=0; i<threadsCount; i++) {
            threads[i] = new Worker(lock, i, counter);
            threads[i].start();
        }
    }
}
