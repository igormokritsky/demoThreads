package com.demo.Multithreading.Task.thirdVariant;

import java.util.concurrent.BlockingQueue;

public class Incrementer implements Runnable {

    BlockingQueue<SharedState> incomingQueue;
    BlockingQueue<SharedState> outcomingQueue;

    public Incrementer(BlockingQueue<SharedState> incomingQueue,
                       BlockingQueue<SharedState> outcomingQueue) {
        this.incomingQueue = incomingQueue;
        this.outcomingQueue = outcomingQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                SharedState state = incomingQueue.take();
                System.out.println(Thread.currentThread().getName() + " took " + state);
                if (state.stop) {
                    outcomingQueue.put(state);
                    break;
                } else if (state.i != 100) {
                    state.i++;

                } else {
                    state.stop = true;
                }
                System.out.println(Thread.currentThread().getName() + " sent " + state);
                outcomingQueue.put(state);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
