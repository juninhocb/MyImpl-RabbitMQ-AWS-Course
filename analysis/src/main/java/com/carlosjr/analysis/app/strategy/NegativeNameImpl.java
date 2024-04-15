package com.carlosjr.analysis.app.strategy;

import com.carlosjr.analysis.app.ProposalDto;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

import static com.carlosjr.analysis.app.strategy.StrategyException.NEGATIVE_NAME;
@Order(1)
@Component
class NegativeNameImpl implements CalculusPoint{

    @Override
    public int calc(ProposalDto proposalDto) {
        var isNegative = verifyNegativeName();
        if (isNegative){
            throw new StrategyException(NEGATIVE_NAME, proposalDto.user().name());
        }
        return 100;
    }
    private boolean verifyNegativeName(){
        return new Random().nextBoolean();
    }

}
