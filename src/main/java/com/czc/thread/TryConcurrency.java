package com.czc.thread;

/**
 * 线程的生命周期大体可以分为5个：new/runnable/running/blocked/terminated
 */

import java.util.concurrent.TimeUnit;

/**
 * @author changzhichen
 * @date 2020-05-01 11:06
 */
public class TryConcurrency {

    public static void main(String[] args) {
        Thread thread = new Thread(TryConcurrency::browseNews);
//        thread.start();
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        thread.start();
        enjoyMusic();
    }

    private static void browseNews() {
        while (true) {
            System.out.println("the good news.");
            sleep(1);
        }
    }

    private static void enjoyMusic() {
        while (true) {
            System.out.println("the good music.");
            sleep(1);
        }
    }

    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
