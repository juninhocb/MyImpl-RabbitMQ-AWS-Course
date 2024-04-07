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
    List<ProposalDto> getAll(){
        return proposalRepository
                .findAll()
                .stream()
                .map(proposalMapper::entityToDto)
                .toList();
    }

    ProposalDto create(ProposalDto proposal){
        return proposalMapper
                .entityToDto(
                        proposalRepository
                                .save(proposalMapper.dtoToEntity(proposal)));
    }



}
