package com.czc.ticket;

/**
 * @author changzhichen
 * @date 2020-05-01 17:41
 */
public class TestRunnable {

    public static void main(String[] args) {
        final TicketWindowRunnable ticketWindow2 = new TicketWindowRunnable();

        Thread thread1 = new Thread(ticketWindow2, "1号柜台");
        Thread thread2 = new Thread(ticketWindow2, "2号柜台");
        Thread thread3 = new Thread(ticketWindow2, "3号柜台");
        Thread thread4 = new Thread(ticketWindow2, "4号柜台");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
