package com.carlosjr.notify.app;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

record ProposalDto(
        UUID id,
        Double requestValue,
        Integer paymentTerm,
        Boolean approved,
        String obs,
        UserDto user) {
}
