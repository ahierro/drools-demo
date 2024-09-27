package com.spring.drools.drools_demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RuleOutputDTO {
    private String ruleName;
    private String result;
}
