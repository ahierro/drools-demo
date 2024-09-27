package com.spring.drools.drools_demo.exceptions;

public class LoopingRuleException extends RuntimeException  {
    public LoopingRuleException(String message) {
        super(message);
    }
}
