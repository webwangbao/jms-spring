package com.myimooc.jmsspring.producer;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

/**
 * @Author : wangbao02
 * @Date : 14:48 2018/3/14/0014
 * @Description :
 */
@Service
public class ProducerServiceImpl implements ProducerService {
    //添加日志信息
    public static final Logger logger = LoggerFactory.getLogger(ProducerServiceImpl.class);

    //注入模板引擎
    @Autowired
    private JmsTemplate jmsTemplate;

    //目标地址（队列）
    @Resource(name = "queueDestination")
    private Destination queueDestination;
    //目标地址（主题）
    @Resource(name = "topicDestination")
    private Destination topicDestination;

    //生产者，发送消息（队列模式）
    @Override
    public void sendMessageQueue(final String message) {

        jmsTemplate.send(queueDestination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(message);
                logger.info("队列模式-发送消息：" + textMessage.getText());
                return textMessage;
            }
        });

    }
   //生产者发送消息（主题模式）
    @Override
    public void sendMessageTopic(String message) {
        jmsTemplate.send(topicDestination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(message);
                logger.info("主题模式-发送消息" + textMessage.getText());
                return textMessage;
            }
        });
    }
}
