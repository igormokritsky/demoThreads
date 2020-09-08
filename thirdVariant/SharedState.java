package com.demo.Multithreading.Task.thirdVariant;

public class SharedState {

    volatile int i = 0;
    boolean stop = false;

    @Override
    public String toString() {
        return "SharedState{" +
                "i=" + i + '}';
    }

}
