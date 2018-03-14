package com.myimooc.jmsspring.producer;

/**
 * @Author : wangbao02
 * @Date : 14:45 2018/3/14/0014
 * @Description :
 */
public interface ProducerService {
    //发送字符串消息到消息服务-队列
    void sendMessageQueue(String message);
   //发送字符串消息到服务-主题
    void sendMessageTopic(String message);
}
