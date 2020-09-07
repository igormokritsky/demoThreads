package com.demo.Multithreading.Task.firstVariant;

public class ResourceLock {
    public volatile int flag;
    public final int threadsCount;

    public ResourceLock(int threadsCount) {
        this.flag = 0;
        this.threadsCount = threadsCount;
    }
}
