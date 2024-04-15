package com.carlosjr.analysis.app.strategy;

import com.carlosjr.analysis.app.ProposalDto;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

import static com.carlosjr.analysis.app.strategy.StrategyException.SHORT_SCORE;

@Order(2)
@Component
class ScoreCalcImpl implements CalculusPoint {
    @Override
    public int calc(ProposalDto proposalDto) {
        var points = getPoints();
        if (points < 200){
            throw new StrategyException(SHORT_SCORE, proposalDto.user().name());
        } else if (points < 500){
            return 150;
        } else if (points < 800){
            return 180;
        } else {
            return 200;
        }
    }

    private int getPoints(){
        return new Random().nextInt(0, 1000);
    }
}
