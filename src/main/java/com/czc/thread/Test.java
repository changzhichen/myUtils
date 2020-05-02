package com.czc.thread;

/**
 * @author changzhichen
 * @date 2020-05-01 18:30
 */
public class Test {
    public static void main(String[] args) {
        // 输出默认5个线程名称
       /* IntStream.range(0, 5).boxed()
                .map(i -> new Thread(
                            () -> System.out.println(Thread.currentThread().getName())
                        )
                ).forEach(Thread::start);*/
        Thread thread = new Thread();
        thread.start();
        thread.setName("线程1");
        System.out.println(thread.getName());
        thread.setName("线程2");
        System.out.println(thread.getName());
    }
}
