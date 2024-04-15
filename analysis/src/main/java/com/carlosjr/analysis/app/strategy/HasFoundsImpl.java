package com.carlosjr.analysis.app.strategy;

import com.carlosjr.analysis.app.ProposalDto;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(4)
@Component
class HasFoundsImpl implements CalculusPoint{
    @Override
    public int calc(ProposalDto proposalDto) {
        var rent = proposalDto.user().rent();
        var requested = proposalDto.requestValue();
        return verify(rent, requested) ? 100 : 0;
    }

    private boolean verify(Double rent, Double requested){
        return rent > requested;
    }

}
