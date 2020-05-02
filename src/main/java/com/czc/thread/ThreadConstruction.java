package com.czc.thread;

/**
 * @author changzhichen
 * @date 2020-05-02 08:57
 */
public class ThreadConstruction {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("enter the stack size.");
            System.exit(1);
        }
        ThreadGroup threadGroup = new ThreadGroup("testGroup");
        Runnable runnable = new Runnable() {
            final int MAX = Integer.MAX_VALUE;

            @Override
            public void run() {
                int i = 0;
                recurse(i);
            }

            private void recurse(int i) {
                System.out.println(i);
                if (i < MAX) {
                    recurse(i + 1);
                }
            }

        };
        Thread thread = new Thread(threadGroup, runnable, "Test", Integer.parseInt(args[0]));
        thread.start();
    }
}
