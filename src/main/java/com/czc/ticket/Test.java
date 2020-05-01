package com.czc.ticket;

/**
 * @author changzhichen
 * @date 2020-05-01 17:41
 */
public class Test {

    public static void main(String[] args) {
        TicketWindow ticketWindow1 = new TicketWindow("1号柜台");
        ticketWindow1.start();

        TicketWindow ticketWindow2 = new TicketWindow("2号柜台");
        ticketWindow2.start();

        TicketWindow ticketWindow3 = new TicketWindow("3号柜台");
        ticketWindow3.start();

        TicketWindow ticketWindow4 = new TicketWindow("4号柜台");
        ticketWindow4.start();
    }
}
