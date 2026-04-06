package pro.samarts.apachekafkaedu.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import pro.samarts.apachekafkaedu.dto.UserEvent;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "messages-topic", groupId = "edu-group")
    public void consume(UserEvent event) {
        System.out.println("LOG [Consumer]: Processed UserEvent -> " +
                           "User: " + event.getUserName() +
                           " (ID: " + event.getUserId() + ") " +
                           "Action: " + event.getAction());
    }
}
