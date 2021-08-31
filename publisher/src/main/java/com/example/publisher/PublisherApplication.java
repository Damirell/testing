package com.example.publisher;

import com.example.publisher.service.MessageSender;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@RequiredArgsConstructor
public class PublisherApplication {

	private final MessageSender messageSender;

	public static void main(String[] args) {
		SpringApplication.run(PublisherApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void sendMessages() {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);

		for (int i = 1; i <= 4; i++) {
			executor.scheduleAtFixedRate(messageSender::send, 5, i, TimeUnit.SECONDS);
		}
	}

}
