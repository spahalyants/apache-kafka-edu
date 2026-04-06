package pro.samarts.apachekafkaedu.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "messages-topic", groupId = "edu-group")
    public void consume(String message) {
        // This method will be triggered whenever a new message arrives
        System.out.println("LOG [Consumer]: Received new message -> " + message);
    }
}
