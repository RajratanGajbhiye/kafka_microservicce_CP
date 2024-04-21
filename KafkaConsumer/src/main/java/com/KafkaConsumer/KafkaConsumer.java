package com.KafkaConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	
	private Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
	
	private KafkaConsumerRepo kafkaRepo;
	
	public KafkaConsumer(KafkaConsumerRepo kafkaRepo) {
		this.kafkaRepo = kafkaRepo;
	}

	@KafkaListener(topics = "rajKafkaMicroTopic", groupId = "consumerGroup")
	public void kafkaConsume(String message) {
		
		logger.info("Kafka consumer message : "+message);
		WikiMedia data = new WikiMedia();
		data.setEventData(message);
		
		kafkaRepo.save(data);
		
	}
	
}
