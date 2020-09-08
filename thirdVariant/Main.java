package com.demo.Multithreading.Task.thirdVariant;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Integer i = 0;
        BlockingQueue<Integer> t1t2 = new LinkedTransferQueue<>();
        BlockingQueue<Integer> t2t3 = new LinkedTransferQueue<>();
        BlockingQueue<Integer> t3t1 = new LinkedTransferQueue<>();
        t1t2.put(i);
        new Thread(new Incrementer(t3t1, t1t2)).start();
        new Thread(new Incrementer(t1t2, t2t3)).start();
        new Thread(new Incrementer(t2t3, t3t1)).start();
    }

}
