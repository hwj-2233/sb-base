package com.zyuc.log.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author hongwj
 * @date 2020/12/30
 **/
@Component
@RabbitListener(queues = "TestDirectQueue")
@Slf4j
public class DirectReceiver {

    //监听的队列名称 TestDirectQueue

    @RabbitHandler
    public void process01(String testMessage) {
        log.info("01消费者收到消息  : " + testMessage.toString());
    }

}
