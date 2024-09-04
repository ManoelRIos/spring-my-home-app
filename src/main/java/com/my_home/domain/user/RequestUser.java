package com.my_home.domain.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestUser(

                String id,
                @NotBlank @NotNull String username,
                @NotBlank @NotNull String password,
                @NotBlank @NotNull String firstName,
                @NotBlank @NotNull String lastName) {

}
