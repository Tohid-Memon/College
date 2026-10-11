package com.maharashtra.tourism.dto;
import java.math.BigDecimal;
public record BudgetResponse(BigDecimal accommodation, BigDecimal food, BigDecimal transportation, BigDecimal miscellaneous, BigDecimal total, BigDecimal perPerson, int nights, String assumption) {}
