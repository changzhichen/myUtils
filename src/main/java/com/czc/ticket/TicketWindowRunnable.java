package com.czc.ticket;

/**
 * @author changzhichen
 * @date 2020-05-01 17:39
 */
public class TicketWindowRunnable implements Runnable {

    private final int MAX_TICKET_NO = 500;

    private int index = 1;

    @Override
    public void run() {
        while (index <= MAX_TICKET_NO) {
            System.out.println(Thread.currentThread() + " 正在出号：" + (index++));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
