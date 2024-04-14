package com.carlosjr.notify.app;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProposalListener {

    final NotificationService notificationService;
    final String PENDENT_PROPOSAL_MS_NOTIFICATION = "proposta-pendente.ms-notificacao";
    @RabbitListener(queues = PENDENT_PROPOSAL_MS_NOTIFICATION)
    void pendentProposal(ProposalDto proposalDto){
        String message = STR."Bem vindo(a) \{proposalDto.user().name()}, sua proposta est\u00E1 em an\u00E1lise";
        notificationService.notifySns(proposalDto.user().phone(), message);
    }

}
