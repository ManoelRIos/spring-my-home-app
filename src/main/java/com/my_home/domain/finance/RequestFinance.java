package com.my_home.domain.finance;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestFinance(
    String id,
    @NotBlank @NotNull String description,
    @NotNull Integer amount,
    @NotBlank @NotNull String note,
    @NotNull Integer transactionType) {
}
