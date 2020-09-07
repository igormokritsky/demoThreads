package com.demo.Multithreading.Task.secondVariant;


public class Test implements Runnable  {
    public int limit = 100;
    static int number = 1;
    int remainder;
    static final Object lock = new Object();

    Test(int remainder)
    {
        this.remainder = remainder;
    }

    public static void main(String[] args) {

        Test runnable1 = new Test(1);
        Test runnable2 = new Test(2);
        Test runnable3 = new Test(0);

        Thread t1 = new Thread(runnable1,"T1");
        Thread t2 = new Thread(runnable2,"T2");
        Thread t3 = new Thread(runnable3,"T3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch ( Exception e) {
            System.out.println("Interrupted");
        }

    }

    @Override
    public void run() {
        while (number < limit - 1) {
            synchronized (lock) {
                while (number % 3 != remainder) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + number);
                number++;
                lock.notifyAll();
            }
        }
    }
}

