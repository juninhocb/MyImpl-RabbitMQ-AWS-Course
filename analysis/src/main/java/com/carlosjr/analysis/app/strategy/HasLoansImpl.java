package com.carlosjr.analysis.app.strategy;

import com.carlosjr.analysis.app.ProposalDto;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

@Order(3)
@Component
class HasLoansImpl implements CalculusPoint{
    @Override
    public int calc(ProposalDto proposalDto) {
        return verifyLoans() ? 0 : 100;
    }

    private boolean verifyLoans(){
        return new Random().nextBoolean();
    }
}
