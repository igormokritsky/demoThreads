package com.demo.Multithreading.Task.thirdVariant;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class SharedTQ {
    int i;

    TransferQueue<Integer> transferQueue = new LinkedTransferQueue<Integer>();

    public void get(){
        try {
            System.out.println("Consumer recd - " + transferQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void put(int i){
        this.i = i;
        try {
            System.out.println("Putting - " + i);
            transferQueue.transfer(i);

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
