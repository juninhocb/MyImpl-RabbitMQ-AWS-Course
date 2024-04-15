package com.carlosjr.analysis.app;

import com.carlosjr.analysis.app.strategy.CalculusPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.carlosjr.analysis.app.RabbitMqConfig.EXCHANGE_CONCLUDE;

@Component
@RequiredArgsConstructor
class AppListener {

    final List<CalculusPoint> calculusPoints;
    final NotificationService notificationService;
    @RabbitListener(queues = EXCHANGE_CONCLUDE)
    void listen(ProposalDto proposalDto){
        calculusPoints.forEach(System.out::println);

    }
}
