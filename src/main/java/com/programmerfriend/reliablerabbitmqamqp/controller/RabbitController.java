package com.programmerfriend.reliablerabbitmqamqp.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rabbit")
public class RabbitController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/test/{name}")
    public String testApi(@PathVariable("name") String name) {
        rabbitTemplate.convertAndSend("tutorial-exchange", "primaryRoutingKey", "Hello, world " + name + "!!!");
        return "Success";
    }

}
