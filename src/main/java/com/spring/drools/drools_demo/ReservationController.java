package com.spring.drools.drools_demo;

import com.spring.drools.drools_demo.dto.OutputCollectorDTO;
import com.spring.drools.drools_demo.dto.ReservationDTO;
import com.spring.drools.drools_demo.dto.ResultDTO;
import com.spring.drools.drools_demo.dto.RulesHitDTO;
import com.spring.drools.drools_demo.listeners.RuleHitAgendaEventListener;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Slf4j
@RestController
@RequestMapping("/api/reservations")
@AllArgsConstructor
public class ReservationController {

    private final KieContainer kContainer;

    @PostMapping("/calculate")
    public ResultDTO calculateMultiplier(@RequestBody ReservationDTO reservationDTO) {

        StatelessKieSession kieSession = kContainer.newStatelessKieSession();
        RuleHitAgendaEventListener ruleHitAgendaEventListener = new RuleHitAgendaEventListener(10000);
        kieSession.addEventListener(ruleHitAgendaEventListener);
        kieSession.setGlobal("outputCollector", new OutputCollectorDTO());

        kieSession.execute(reservationDTO);

        return new ResultDTO(reservationDTO,
                ruleHitAgendaEventListener.getRuleHits().cellSet().stream().map(cell -> RulesHitDTO.builder()
                        .ruleName(cell.getRowKey())
                        .packageName(cell.getColumnKey())
                        .hitCount(cell.getValue())
                        .build()).toList(), (OutputCollectorDTO) kieSession.getGlobals().get("outputCollector"));
    }
}
