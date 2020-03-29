package com.ixingji;

public class Singleton {

    private static Singleton instance = null;

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        System.err.println(Singleton.getInstance().hashCode());
        System.err.println(Singleton.getInstance().hashCode());
    }

}
