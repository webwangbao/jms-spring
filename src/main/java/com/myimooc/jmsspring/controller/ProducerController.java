package com.myimooc.jmsspring.controller;

import com.myimooc.jmsspring.producer.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author : wangbao02
 * @Date : 14:58 2018/3/14/0014
 * @Description :
 */
@Controller
@RequestMapping("/send")
public class ProducerController {
    @Autowired
    private ProducerService producerService;

    @RequestMapping("/queue")
    @ResponseBody
    public Object sendMessageQueue(String message){
     producerService.sendMessageQueue(message);
        return true;
    }

    @RequestMapping("/topic")
    @ResponseBody
    public Object sendMessageTopic(String message){
        producerService.sendMessageTopic(message);
        return true;
    }

}
