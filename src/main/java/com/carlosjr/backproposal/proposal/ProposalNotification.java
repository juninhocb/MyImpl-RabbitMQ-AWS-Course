package com.carlosjr.backproposal.proposal;

import com.carlosjr.backproposal.rabbitmq.RabbitMqConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
class ProposalNotification {

    private final RabbitTemplate rabbitTemplate;
    void notifyProposal(Proposal proposal){
        rabbitTemplate
                .convertAndSend(RabbitMqConfig.EXCHANGE_PENDENT, "", proposal);
    }

}
