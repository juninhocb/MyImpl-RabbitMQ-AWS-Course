package com.carlosjr.backproposal.proposal;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

import java.util.UUID;

record ProposalDto(
                   @Null
                   UUID id,
                   @JsonProperty("nome")
                   @NotBlank String name,
                   @JsonProperty("sobrenome")
                   @NotBlank String lastName,
                   @JsonProperty("telefone")
                   @NotBlank String phone,
                   @NotBlank String cpf,
                   @JsonProperty("renda")
                   @NotNull Double rent,
                   @JsonProperty("valorSolicitado")
                   @NotNull Double requestValue,
                   @JsonProperty("prazoPagamento")
                   @NotNull Integer paymentTerm,
                   @JsonProperty("aprovada")
                   @Null Boolean approved,
                   @JsonProperty("observacao")
                   @Null String obs) {
}
