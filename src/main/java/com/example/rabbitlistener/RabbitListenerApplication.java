package com.example.rabbitlistener;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitListenerApplication implements CommandLineRunner {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  public static void main(String[] args) {
    SpringApplication.run(RabbitListenerApplication.class, args);
  }

  @Override
  public void run(String... strings) {

    SimpleMessage simpleMessage = new SimpleMessage();
    simpleMessage.setName("FirstMessage");
    simpleMessage.setDescription("simpleDescription");

    rabbitTemplate.convertAndSend("MyTestExchange", "simple", "simpleMessage");
  }
}
