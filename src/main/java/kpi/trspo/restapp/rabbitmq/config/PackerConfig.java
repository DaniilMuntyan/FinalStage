package kpi.trspo.restapp.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class PackerConfig {
    @Bean
    public Queue create_packer_queue() {
        return new Queue(MessagingConfig.CREATE_PACKER_QUEUE);
    }

    @Bean
    public Queue response_packer_queue() {
        return new Queue(MessagingConfig.RESPONSE_PACKER_QUEUE);
    }

    @Bean
    public Binding binding_create_packer(Queue create_packer_queue, DirectExchange exchange) {
        return BindingBuilder.bind(create_packer_queue).to(exchange).with(MessagingConfig.CREATE_PACKER_ROUTING);
    }

    @Bean
    public Binding binding_response_packer(Queue response_packer_queue, DirectExchange exchange) {
        return BindingBuilder.bind(response_packer_queue).to(exchange).with(MessagingConfig.RESPONSE_PACKER_ROUTING);
    }

    @Bean
    public Queue get_packers_queue() {
        return new Queue(MessagingConfig.GET_PACKERS_QUEUE);
    }

    @Bean
    public Queue response_get_packers_queue() {
        return new Queue(MessagingConfig.RESPONSE_ALL_PACKERS_QUEUE);
    }

    @Bean
    public Binding binding_get_packers(Queue get_packers_queue, DirectExchange exchange) {
        return BindingBuilder.bind(get_packers_queue).to(exchange).with(MessagingConfig.GET_PACKERS_ROUTING);
    }

    @Bean
    public Binding binding_response_get_packers(Queue response_get_packers_queue, DirectExchange exchange) {
        return BindingBuilder.bind(response_get_packers_queue).to(exchange).with(MessagingConfig.RESPONSE_ALL_PACKERS_ROUTING);
    }
}
