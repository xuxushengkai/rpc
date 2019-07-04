package com.sjj.rpc;

import java.io.Serializable;

/**
 * @ClassName Ticket
 * @Description 票
 * @Author shengjunjie
 * Date 2019/7/3 16:14
 **/
public class Ticket implements Serializable {

    private String trainName;

    private Integer ticketNum;

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public Integer getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(Integer ticketNum) {
        this.ticketNum = ticketNum;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "trainName='" + trainName + '\'' +
                ", ticketNum=" + ticketNum +
                '}';
    }

    public Ticket(String trainName, Integer ticketNum) {
        this.trainName = trainName;
        this.ticketNum = ticketNum;
    }
}
