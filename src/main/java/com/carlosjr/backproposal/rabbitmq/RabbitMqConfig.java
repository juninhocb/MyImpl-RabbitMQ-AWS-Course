package com.carlosjr.backproposal.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    final String PENDENT_PROPOSAL_MS_CREDIT_ANALYSIS = "proposta-pendente.ms-analise-credito";
    final String PENDENT_PROPOSAL_MS_NOTIFICATION = "proposta-pendente.ms-notificacao";
    final String CONCLUDE_PROPOSAL_MS_CREDIT_ANALYSIS = "proposta-concluida.ms-proposta";
    final String CONCLUDE_PROPOSAL_MS_NOTIFICATION = "proposta-concluida.ms-notification";
    public static final String EXCHANGE_PENDENT = "proposta-pendente.ex";
    public static final String EXCHANGE_CONCLUDE = "proposta-concluida.ex";
    @Bean
    public Queue queueOne(){
        return QueueBuilder
                .durable(PENDENT_PROPOSAL_MS_CREDIT_ANALYSIS)
                .build();
    }

    @Bean
    public FanoutExchange exchangeOne(){
        return ExchangeBuilder
                .fanoutExchange(EXCHANGE_PENDENT)
                .build();
    }

    @Bean
    public Binding bindingOne(@Qualifier("queueOne") Queue queue,
                              @Qualifier("exchangeOne") FanoutExchange fanoutExchange){
        return BindingBuilder
                .bind(queue)
                .to(fanoutExchange);
    }

    @Bean
    public Queue queueTwo(){
        return QueueBuilder
                .durable(PENDENT_PROPOSAL_MS_NOTIFICATION)
                .build();
    }

    @Bean
    public Binding bindingTwo(@Qualifier("queueTwo") Queue queue,
                              @Qualifier("exchangeOne") FanoutExchange fanoutExchange){
        return BindingBuilder
                .bind(queue)
                .to(fanoutExchange);
    }

    @Bean
    public Queue queueThree(){
        return QueueBuilder
                .durable(CONCLUDE_PROPOSAL_MS_CREDIT_ANALYSIS)
                .build();
    }

    @Bean
    public FanoutExchange exchangeTwo(){
        return ExchangeBuilder
                .fanoutExchange(EXCHANGE_CONCLUDE)
                .build();
    }

    @Bean
    public Binding bindingThree(@Qualifier("queueThree") Queue queue,
                              @Qualifier("exchangeTwo") FanoutExchange fanoutExchange){
        return BindingBuilder
                .bind(queue)
                .to(fanoutExchange);
    }

    @Bean
    public Queue queueFour(){
        return QueueBuilder
                .durable(CONCLUDE_PROPOSAL_MS_NOTIFICATION)
                .build();
    }

    @Bean
    public Binding bindingFour(@Qualifier("queueFour") Queue queue,
                                @Qualifier("exchangeTwo") FanoutExchange fanoutExchange){
        return BindingBuilder
                .bind(queue)
                .to(fanoutExchange);
    }
    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory){
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        var rt = new RabbitTemplate();
        rt.setConnectionFactory(connectionFactory);
        rt.setMessageConverter(new Jackson2JsonMessageConverter());
        return rt;
    }

    @Bean
    public ApplicationRunner startup(RabbitAdmin rabbitAdmin){
        return args -> {
            rabbitAdmin.initialize();
        };
    }

}
