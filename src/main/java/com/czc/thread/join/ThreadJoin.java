package com.czc.thread.join;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author changzhichen
 * @date 2020-05-02 09:47
 */
public class ThreadJoin {
    /**
     * join 方法很重要，有非常多的应用场景，串行任务局部并行化处理
     * 生效的前提：线程必须先start，再把线程全部join即可
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threadList = IntStream.range(1, 3).mapToObj(ThreadJoin::create).collect(Collectors.toList());

        threadList.forEach(Thread::start);

        for (Thread thread : threadList) {
            thread.join();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "#" + i);
            shortSleep();
        }
    }

    private static Thread create(int seq) {
        return new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "#" + i);
                shortSleep();
            }
        }, String.valueOf(seq));
    }

    private static void shortSleep() {
        /*try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}
