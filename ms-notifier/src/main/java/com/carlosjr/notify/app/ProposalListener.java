package com.carlosjr.notify.app;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ProposalListener {

    @RabbitListener(queues = "")
    void pendentProposal(){

    }

}
