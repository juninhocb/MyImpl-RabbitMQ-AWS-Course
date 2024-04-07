package com.carlosjr.backproposal.proposal;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
class ProposalService {

    private final ProposalRepository proposalRepository;
    private final ProposalMapper proposalMapper;
    private final ProposalNotification proposalNotification;

    List<ProposalDto> getAll(){
        return proposalRepository
                .findAll()
                .stream()
                .map(proposalMapper::entityToDto)
                .toList();
    }

    ProposalDto create(ProposalDto proposalDto){
        var createdResource = proposalRepository
                .save(proposalMapper.dtoToEntity(proposalDto));

        notifyRabbitMq(createdResource);
        return proposalMapper.entityToDto(createdResource);
    }

    private void notifyRabbitMq(Proposal proposal){
        try {
            proposalNotification.notifyProposal(proposal);
        } catch (RuntimeException e){
            proposal.setIntegrated(false);
            proposalRepository.save(proposal);
        }
    }


}
