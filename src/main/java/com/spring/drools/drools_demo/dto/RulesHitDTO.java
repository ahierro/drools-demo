package com.spring.drools.drools_demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RulesHitDTO {
    private String ruleName;
    private String packageName;
    private Integer hitCount;
}
