package com.czc.ticket;

/**
 * @author changzhichen
 * @date 2020-05-01 17:39
 */
public class TicketWindow extends Thread {

    private String windowName;

    private final int MAX_TICKET_NO = 500;

    /**
     * 此处static很重要
     * 如果不用static修饰，则每个线程都会执行 MAX_TICKET_NO 次
     * 如果用static修饰，则共享index资源，但是也不是线程安全的（当MAX_TICKET_NO值很大的时候，
     * 依然会出现线程安全问题）
     */
    private static Integer index = 1;

    @Override
    public void run() {
        while (index <= MAX_TICKET_NO) {
            System.out.println(windowName + " 正在出号：" + (index++));
        }
    }

    TicketWindow(String windowName) {
        this.windowName = windowName;
    }
}
