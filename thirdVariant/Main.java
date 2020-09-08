package com.demo.Multithreading.Task.thirdVariant;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        new Main().starter();
    }

    public void starter() throws InterruptedException {

        SharedState sharedState = new SharedState();
        BlockingQueue<SharedState> t1t2 = new LinkedTransferQueue<>();
        BlockingQueue<SharedState> t2t3 = new LinkedTransferQueue<>();
        BlockingQueue<SharedState> t3t1 = new LinkedTransferQueue<>();
        t1t2.put(sharedState);
        new Thread(new Incrementer(t3t1, t1t2)).start();
        new Thread(new Incrementer(t1t2, t2t3)).start();
        new Thread(new Incrementer(t2t3, t3t1)).start();
    }
}
