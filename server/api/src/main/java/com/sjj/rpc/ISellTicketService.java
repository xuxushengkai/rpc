package com.sjj.rpc;

/**
 * @ClassName ISellTicketService
 * @Description 售票接口
 * Author shengjunjie
 * Date 2019/7/3 16:13
 **/
public interface ISellTicketService {

    String getTicketNum(Ticket ticket);

    void removeTicket(Ticket ticket);

}
