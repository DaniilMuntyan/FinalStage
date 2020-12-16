package kpi.trspo.restapp.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FinalStageConfig {
    @Bean
    public Queue final_stage_queue() {
        return new Queue(MessagingConfig.FINAL_STAGE_QUEUE);
    }

    @Bean
    public Queue response_final_stage_queue() {
        return new Queue(MessagingConfig.RESPONSE_FINAL_STAGE_QUEUE);
    }

    @Bean
    public Binding binding_final_stage(Queue final_stage_queue, DirectExchange exchange) {
        return BindingBuilder.bind(final_stage_queue).to(exchange).with(MessagingConfig.FINAL_STAGE_ROUTING);
    }

    @Bean
    public Binding binding_response_final_stage(Queue response_final_stage_queue, DirectExchange exchange) {
        return BindingBuilder.bind(response_final_stage_queue).to(exchange).with(MessagingConfig.RESPONSE_FINAL_STAGE_ROUTING);
    }
}
