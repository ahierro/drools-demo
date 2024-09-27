package com.spring.drools.drools_demo.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OutputCollectorDTO {
    private List<RuleOutputDTO> ruleOutputList = new ArrayList<>();

    public void addRuleOutput(RuleOutputDTO ruleOutput) {
        ruleOutputList.add(ruleOutput);
    }
}
