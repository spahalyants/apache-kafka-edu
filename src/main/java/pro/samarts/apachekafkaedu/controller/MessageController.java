package pro.samarts.apachekafkaedu.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/api/v1/send")
    public String publish(@RequestParam("msg") String message) {
        // Send message to the topic we defined in KafkaConfig
        kafkaTemplate.send("messages-topic", message);
        return "Message sent to Kafka: " + message;
    }
}
