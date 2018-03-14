package com.myimooc.jmsspring.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @Author : wangbao02
 * @Date : 14:42 2018/3/14/0014
 * @Description :
 */
//消费者消息监听（主题模式）
public class ConsumerTopicMessageListener implements MessageListener {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerTopicMessageListener.class);

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;

        try {
           logger.info("接受消息"+textMessage.getText());
        } catch (JMSException e) {
            logger.info("接受消息异常");
            e.printStackTrace();
        }
    }
}
