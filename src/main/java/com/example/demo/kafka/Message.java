package com.example.demo.kafka;

import lombok.Data;

import java.util.Date;

@Data
public class Message {
    public Long id;    //id

    public String msg; //消息

    public Date sendTime;  //时间戳
}