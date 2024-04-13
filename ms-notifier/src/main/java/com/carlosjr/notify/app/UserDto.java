package com.carlosjr.notify.app;

import java.util.UUID;

record UserDto(
        UUID id,
        String name,
        String lastName,
        String cpf,
        String phone,
        Double rent) {
}
