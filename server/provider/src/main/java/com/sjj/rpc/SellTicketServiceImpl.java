package com.sjj.rpc;

/**
 * @ClassName SellTicketServiceImpl
 * @Description TODO
 * @Author shengjunjie
 * Date 2019/7/4 9:51
 **/
@RpcService(value = ISellTicketService.class,version = "v1.0")
public class SellTicketServiceImpl implements ISellTicketService {

    @Override
    public String getTicketNum(Ticket ticket) {
        String result = "【v1.0】当前车次："+ticket.getTrainName()+"余票："+ticket.getTicketNum();
        return result;
    }

    @Override
    public void removeTicket(Ticket ticket) {
        System.out.println(getTicketNum(ticket));
    }


}
