package com.carlosjr.backproposal.proposal;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/proposta")
@RequiredArgsConstructor
class ProposalController {

    private final ProposalService proposalService;

    @GetMapping
    ResponseEntity<List<ProposalDto>> getAll(){
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(proposalService.getAll());

    }

    @PostMapping
    ResponseEntity<ProposalDto> create(@RequestBody @Valid ProposalDto request,
                                       UriComponentsBuilder ucb){

        var createdResource =  proposalService.create(request);
        var uri = ucb
                    .path("/proposta/{id}")
                    .buildAndExpand(createdResource.id())
                    .toUri();
        return ResponseEntity
                .created(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .body(createdResource);
    }

}
