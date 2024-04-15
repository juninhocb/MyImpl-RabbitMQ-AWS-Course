package com.carlosjr.analysis.app;

import java.util.UUID;

public record UserDto(
        UUID id,
        String name,
        String lastName,
        String cpf,
        String phone,
        Double rent) {
}
