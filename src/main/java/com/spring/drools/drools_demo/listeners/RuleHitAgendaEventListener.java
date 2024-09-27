package com.spring.drools.drools_demo.listeners;

import com.spring.drools.drools_demo.exceptions.LoopingRuleException;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.kie.api.event.rule.*;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

@Log4j2
@Getter
public class RuleHitAgendaEventListener extends DefaultAgendaEventListener {


    private final Table<String, String, Integer> ruleHits = HashBasedTable.create();
    private final Integer loopRuleLimit;

    public RuleHitAgendaEventListener(Integer loopRuleLimit) {
        this.loopRuleLimit = loopRuleLimit;
    }

    @Override
    public void beforeMatchFired(BeforeMatchFiredEvent event) {
        log.info("Before match fired: {}", event.toString());
    }

    @Override
    public void afterMatchFired(AfterMatchFiredEvent event) {
        if (event != null && event.getMatch() != null && event.getMatch().getRule() != null) {
            String ruleName = event.getMatch().getRule().getName();
            String rulePackageName = event.getMatch().getRule().getPackageName();
            int hitCount = ruleHits.contains(ruleName, rulePackageName) ? getHitCountByRule(ruleName, rulePackageName) : 0;
            hitCount++;
            ruleHits.put(ruleName, rulePackageName, hitCount);
            log.info("Hit rule \"{}\" from package \"{}\"", ruleName,rulePackageName);
//            if (loopRuleLimit != null && hitCount > loopRuleLimit) {
//                throw new LoopingRuleException("Possible Looping Rule detected. Rule: " + ruleName + ". Package: " + rulePackageName);
//            }
        }
    }

    private Integer getHitCountByRule(String ruleName, String rulePackageName) {
        Integer result = ruleHits.get(ruleName, rulePackageName);
        if (result == null) {
            return 0;
        }
        return result;
    }
}
