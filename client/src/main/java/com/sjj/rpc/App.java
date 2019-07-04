package com.sjj.rpc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static  Ticket ticket = new Ticket("G600",100);
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
        RpcProxyClient rpcProxyClient=context.getBean(RpcProxyClient.class);
        ISellTicketService service =  rpcProxyClient.clientProxy(ISellTicketService.class,"localhost",9090);
        for(int i=0;i<10;i++){
            ticket.setTicketNum(ticket.getTicketNum()-1);
            service.removeTicket(ticket);
        }


    }

}
