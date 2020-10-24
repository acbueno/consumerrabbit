package br.com.acbueno.consumer.listen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.acbueno.consumer.model.EmployeeToJson;
import br.com.acbueno.consumer.service.EmployeeService;

@Component
public class ConsumerMessage {
  
  private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerMessage.class);
  
  @Autowired
  private Queue queues;
  
  @Autowired
  private EmployeeService employeeService;
  
 
  @RabbitListener(queues = "#{queue.getName()}")
  public void receiveMessage(EmployeeToJson customMessage) {
      LOGGER.info("Received message as specific class: {}", customMessage.toString());
      employeeService.createOrUpdate(customMessage);
      
  }

}
