package pro.samarts.apachekafkaedu.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.samarts.apachekafkaedu.dto.UserEvent;

@RestController
public class MessageController {

    // Note the change to <String, Object> or <String, UserEvent>
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public MessageController(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/api/v1/user-action")
    public String sendUserAction(@RequestParam("id") Long id,
                                 @RequestParam("name") String name) {

        UserEvent event = new UserEvent(id, name, "LOGIN_ATTEMPT");

        // We use the ID as the key to ensure order within a partition
        kafkaTemplate.send("messages-topic", String.valueOf(id), event);

        return "JSON Event for user " + name + " sent to Kafka!";
    }
}
