package com.example.hr.adapter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.hr.domain.event.EventBase;
import com.example.hr.infrastructure.EventPublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EventPublisherKafkaAdapter implements EventPublisher {
	@Value("${kafka.topic.name}")
	private String kafkaTopicName;

	private KafkaTemplate<String, String> kafkaTemplate;
	private ObjectMapper objectMapper;

	// constructor injection
	public EventPublisherKafkaAdapter(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
		this.kafkaTemplate = kafkaTemplate;
		this.objectMapper = objectMapper;
	}

	@Override
	public void publish(EventBase event) {
		try {
			kafkaTemplate.send(kafkaTopicName, objectMapper.writeValueAsString(event));
		} catch (JsonProcessingException e) {
			System.err.println("Error in sending message to kafka: " + e.getMessage());
		}

	}

}
