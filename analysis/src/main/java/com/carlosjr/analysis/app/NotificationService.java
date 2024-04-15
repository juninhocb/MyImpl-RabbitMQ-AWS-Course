package com.carlosjr.analysis.app;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class NotificationService {

    final RabbitTemplate rabbitTemplate;
    void notifyQueue(ProposalDto proposalDto){
        rabbitTemplate.convertAndSend(proposalDto);
    }
}
