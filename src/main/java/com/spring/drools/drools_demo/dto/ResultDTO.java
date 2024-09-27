package com.spring.drools.drools_demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class ResultDTO {
    private ReservationDTO reservationDTO;
    private List<RulesHitDTO> rulesHitDTO;
    private OutputCollectorDTO output;
}
