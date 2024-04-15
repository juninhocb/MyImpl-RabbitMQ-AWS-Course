package com.carlosjr.analysis.app;

import java.util.UUID;

public record ProposalDto(
        UUID id,
        Double requestValue,
        Integer paymentTerm,
        Boolean approved,
        String obs,
        UserDto user) {
}
