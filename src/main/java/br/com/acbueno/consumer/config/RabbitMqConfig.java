package br.com.acbueno.consumer.config;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {


  @Value("${rabbitmq.queue}")
  private String queueName;

  @Value("${rabbitmq.exchange}")
  private String exchange;

  @Value("${rabbitmq.routingkey}")
  private String routingKey;

  @Bean
  Queue queue() {
    return new Queue(queueName, Boolean.FALSE);
  }

  @Bean
  TopicExchange topicExchange() {
    return new TopicExchange(exchange);
  }

  @Bean
  Binding binding(final Queue queue, final TopicExchange topicExchange) {
    return BindingBuilder.bind(queue).to(topicExchange).with(routingKey);
  }

  @Bean
  public Jackson2JsonMessageConverter producerJackson2JsonMessageConverter() {
    return new Jackson2JsonMessageConverter();
  }

  @Bean
  public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
    final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
    rabbitTemplate.setMessageConverter(producerJackson2JsonMessageConverter());

    return rabbitTemplate;
  }
  
  @Bean
  public ModelMapper modelMapper() {
     ModelMapper modelMapper = new ModelMapper();
     return modelMapper;
  }

}
