package pro.samarts.apachekafkaedu.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;
import pro.samarts.apachekafkaedu.dto.UserEvent;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "messages-topic", groupId = "edu-group")
    public void consume(UserEvent event,
                        @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) { // Add this header
        System.out.println("LOG [Consumer]: Partition [" + partition + "] " +
            "processed User: " + event.getUserName());
    }
}
