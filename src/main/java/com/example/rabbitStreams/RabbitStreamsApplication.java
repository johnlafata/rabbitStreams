package com.example.rabbitStreams;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.rabbitStreams.model.MessageTransport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableBinding(Sink.class)
public class RabbitStreamsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitStreamsApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	Logger LOGGER = LoggerFactory.getLogger(RabbitStreamsApplication.class);

	@StreamListener(Sink.INPUT)
	public void log(MessageTransport message)  {
		System.out.println("message: "+message);
		LOGGER.info(message.getMessage());
	}

}
