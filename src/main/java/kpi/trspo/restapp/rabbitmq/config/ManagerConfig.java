package kpi.trspo.restapp.rabbitmq.config;

import kpi.trspo.restapp.rabbitmq.config.MessagingConfig;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ManagerConfig {

    @Bean
    public Queue get_all_managers_queue() {
        return new Queue(MessagingConfig.GET_ALL_MANAGERS_QUEUE);
    }

    @Bean
    public Queue response_all_managers_queue() {
        return new Queue(MessagingConfig.RESPONSE_ALL_MANAGERS_QUEUE);
    }

    @Bean
    public Binding binding_get_all_managers(Queue get_all_managers_queue, DirectExchange exchange) {
        return BindingBuilder.bind(get_all_managers_queue).to(exchange).with(MessagingConfig.GET_ALL_MANAGERS_ROUTING);
    }

    @Bean
    public Binding binding_response_all_managers(Queue response_all_managers_queue, DirectExchange exchange) {
        return BindingBuilder.bind(response_all_managers_queue).to(exchange).with(MessagingConfig.RESPONSE_ALL_MANAGERS_ROUTING);
    }

    @Bean
    public Queue create_manager_queue() {
        return new Queue(MessagingConfig.CREATE_MANAGER_QUEUE);
    }

    @Bean
    public Queue response_create_manager_queue() {
        return new Queue(MessagingConfig.RESPONSE_MANAGER_QUEUE);
    }

    @Bean
    public Binding binding_create_manager(Queue create_manager_queue, DirectExchange exchange) {
        return BindingBuilder.bind(create_manager_queue).to(exchange).with(MessagingConfig.CREATE_MANAGER_ROUTING);
    }

    @Bean
    public Binding binding_response_manager(Queue response_create_manager_queue, DirectExchange exchange) {
        return BindingBuilder.bind(response_create_manager_queue).to(exchange).with(MessagingConfig.RESPONSE_MANAGER_ROUTING);
    }
}
