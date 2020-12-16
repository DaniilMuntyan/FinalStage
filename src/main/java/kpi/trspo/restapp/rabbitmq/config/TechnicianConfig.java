package kpi.trspo.restapp.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class TechnicianConfig {
    @Bean
    public Queue create_technician_queue() {
        return new Queue(MessagingConfig.CREATE_TECHNICIAN_QUEUE);
    }

    @Bean
    public Queue response_technician_queue() {
        return new Queue(MessagingConfig.RESPONSE_TECHNICIAN_QUEUE);
    }

    @Bean
    public Binding binding_create_technician(Queue create_technician_queue, DirectExchange exchange) {
        return BindingBuilder.bind(create_technician_queue).to(exchange).with(MessagingConfig.CREATE_TECHNICIAN_ROUTING);
    }

    @Bean
    public Binding binding_response_technician(Queue response_technician_queue, DirectExchange exchange) {
        return BindingBuilder.bind(response_technician_queue).to(exchange).with(MessagingConfig.RESPONSE_TECHNICIAN_ROUTING);
    }

    @Bean
    public Queue get_technicians_queue() {
        return new Queue(MessagingConfig.GET_TECHNICIANS_QUEUE);
    }

    @Bean
    public Queue response_get_technicians_queue() {
        return new Queue(MessagingConfig.RESPONSE_ALL_TECHNICIANS_QUEUE);
    }

    @Bean
    public Binding binding_get_technicians(Queue get_technicians_queue, DirectExchange exchange) {
        return BindingBuilder.bind(get_technicians_queue).to(exchange).with(MessagingConfig.GET_TECHNICIANS_ROUTING);
    }

    @Bean
    public Binding binding_response_get_technicians(Queue response_get_technicians_queue, DirectExchange exchange) {
        return BindingBuilder.bind(response_get_technicians_queue).to(exchange).with(MessagingConfig.RESPONSE_ALL_TECHNICIANS_ROUTING);
    }

}
