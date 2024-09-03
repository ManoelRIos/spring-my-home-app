package com.my_home.domain.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestUser(
    @NotNull @NotNull String username,
    @NotBlank @NotNull String password) {
}
