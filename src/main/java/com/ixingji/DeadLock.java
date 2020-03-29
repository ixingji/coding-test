package com.ixingji;

public class DeadLock {

    private static Object obj1 = new Object();
    private static Object obj2 = new Object();

    static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (obj1) {
                System.err.println("i have obj1");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.err.println("i want to have obj2");
                synchronized (obj2) {
                    System.err.println("-------");
                }
            }
        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (obj2) {
                System.err.println("i have obj2");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.err.println("i want to have obj1");
                synchronized (obj1) {
                    System.err.println("-------");
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }

}
