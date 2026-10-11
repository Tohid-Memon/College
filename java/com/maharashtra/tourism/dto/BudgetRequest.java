package com.maharashtra.tourism.dto;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
public record BudgetRequest(
    @NotNull @Min(1) @Max(50) Integer travellers,
    @NotNull @Min(1) @Max(30) Integer days,
    @NotBlank String hotelCategory,
    @NotNull @Min(1) @Max(50) Integer rooms,
    @NotNull @DecimalMin("0.0") BigDecimal transportation,
    @NotNull @DecimalMin("0.0") BigDecimal dailyFoodPerPerson,
    @NotNull @DecimalMin("0.0") BigDecimal miscellaneous
) {}
