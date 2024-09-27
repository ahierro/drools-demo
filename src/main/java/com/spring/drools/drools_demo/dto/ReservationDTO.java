package com.spring.drools.drools_demo.dto;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReservationDTO {

    @Schema(description = "Duration of the reservation in days", example = "30")
    private Long durationInDays;

    @Schema(description = "Number of passengers for the reservation", example = "2")
    private Long numberOfPassengers;

    @Schema(description = "Whether the reservation includes breakfast", example = "true")
    private Boolean breakfastIncluded;

    @Schema(description = "Whether the customer brings pets", example = "true")
    private Boolean pets;

    @Schema(description = "Whether the reservation is during peak season", example = "false")
    private Boolean peakSeason;

    @Schema(description = "Nationality of the customer", example = "USA")
    private String nationality;

    @Schema(description = "Type of room for the reservation", example = "Standard")
    private String roomType;

    @Schema(description = "Price per day for the reservation", example = "200")
    private BigDecimal roomPricePerDay;

    @Schema(description = "Total price multiplier for the reservation", example = "1")
    private BigDecimal totalPriceMultiplier;

    @Schema(description = "Fixed discount amount for the reservation", example = "0")
    private BigDecimal priceFixedDiscount;

}
