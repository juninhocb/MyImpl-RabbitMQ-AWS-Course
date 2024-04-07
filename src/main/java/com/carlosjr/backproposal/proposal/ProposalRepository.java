package com.carlosjr.backproposal.proposal;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface ProposalRepository extends JpaRepository<Proposal, UUID> {
}
