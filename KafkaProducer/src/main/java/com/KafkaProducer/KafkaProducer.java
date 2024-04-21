package com.KafkaProducer;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import com.launchdarkly.eventsource.background.BackgroundEventSource;

@Service
public class KafkaProducer {
	
	private KafkaTemplate<String, String> template;
	
	
	public KafkaProducer(KafkaTemplate<String, String> template) {
		this.template = template;
	}


	public void sendMessage() throws InterruptedException {
		
		BackgroundEventHandler eventHandler = new KafkaEventHandler(template, "rajKafkaMicroTopic");
		String url = "https://stream.wikimedia.org/v2/stream/recentchange";
		URI uriUrl = URI.create(url);
		EventSource.Builder esBuilder = new EventSource.Builder(uriUrl);
		BackgroundEventSource.Builder eventSource = new BackgroundEventSource.Builder(eventHandler,esBuilder);
		BackgroundEventSource source = eventSource.build();
		source.start();
		TimeUnit.MINUTES.sleep(2);
	}
	
}
