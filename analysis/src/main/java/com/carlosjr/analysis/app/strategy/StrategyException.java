package com.carlosjr.analysis.app.strategy;

import static java.lang.StringTemplate.STR;

class StrategyException extends RuntimeException{
    public static final String NEGATIVE_NAME = "Negative name";
    public static final String SHORT_SCORE = "Short score";
    StrategyException(String msg, String name){
        super(STR."Nevative because \{name} has \{msg}");
    }
}
