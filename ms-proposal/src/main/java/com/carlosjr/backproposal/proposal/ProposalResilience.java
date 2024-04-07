package com.carlosjr.backproposal.proposal;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
class ProposalResilience {

    final ProposalRepository proposalRepository;
    final ProposalNotification proposalNotification;

    @Scheduled(fixedDelay = 20, timeUnit = TimeUnit.SECONDS)
    void tryToIntegrate(){
        proposalRepository.findAllByIntegratedIsFalse()
                .forEach(proposal -> {
                    try {
                        proposalNotification.notifyProposal(proposal);
                        updateProposal(proposal);
                    }catch (RuntimeException ex){
                        //ignore
                    }
                });
    }

    void updateProposal(Proposal proposal){
        proposal.setIntegrated(true);
        proposalRepository.save(proposal);
    }

}
