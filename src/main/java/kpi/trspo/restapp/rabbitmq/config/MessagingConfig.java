package kpi.trspo.restapp.rabbitmq.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {

    public static final String CREATE_MANAGER_QUEUE = "create_manager_queue";
    public static final String CREATE_TECHNICIAN_QUEUE = "create_technician_queue";
    public static final String CREATE_PACKER_QUEUE = "create_packer_queue";
    public static final String GET_ALL_MANAGERS_QUEUE = "get_all_managers_queue";
    public static final String GET_TECHNICIANS_QUEUE = "get_technicians_queue";
    public static final String GET_PACKERS_QUEUE = "get_packers_queue";
    public static final String FINAL_STAGE_QUEUE = "final_stage_queue";

    public static final String RESPONSE_MANAGER_QUEUE = "response_manager_queue";
    public static final String RESPONSE_TECHNICIAN_QUEUE = "response_technician_queue";
    public static final String RESPONSE_PACKER_QUEUE = "response_packer_queue";
    public static final String RESPONSE_ALL_MANAGERS_QUEUE = "response_all_managers_queue";
    public static final String RESPONSE_ALL_TECHNICIANS_QUEUE = "response_all_technicians_queue";
    public static final String RESPONSE_ALL_PACKERS_QUEUE = "response_all_packers_queue";
    public static final String RESPONSE_FINAL_STAGE_QUEUE = "response_final_stage_queue";

    public static final String EXCHANGE = "direct_exchange";

    public static final String CREATE_MANAGER_ROUTING = "create_manager_routing_key";
    public static final String CREATE_TECHNICIAN_ROUTING = "create_technician_routing_key";
    public static final String CREATE_PACKER_ROUTING = "create_packer_routing_key";
    public static final String GET_ALL_MANAGERS_ROUTING = "get_all_managers_routing_key";
    public static final String GET_TECHNICIANS_ROUTING = "get_technicians_routing_key";
    public static final String GET_PACKERS_ROUTING = "get_packers_routing_key";
    public static final String FINAL_STAGE_ROUTING = "final_stage_routing_key";

    public static final String RESPONSE_MANAGER_ROUTING = "response_manager_routing_key";
    public static final String RESPONSE_TECHNICIAN_ROUTING = "response_technician_routing_key";
    public static final String RESPONSE_PACKER_ROUTING = "response_packer_routing_key";
    public static final String RESPONSE_ALL_MANAGERS_ROUTING = "response_all_managers_routing_key";
    public static final String RESPONSE_ALL_TECHNICIANS_ROUTING = "response_all_technicians_routing_key";
    public static final String RESPONSE_ALL_PACKERS_ROUTING = "response_all_packers_routing_key";
    public static final String RESPONSE_FINAL_STAGE_ROUTING = "response_final_stage_routing_key";

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        System.out.println("host = " + connectionFactory.getHost() + " port = " + connectionFactory.getPort() +
                " username = " + connectionFactory.getUsername());
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }

}
