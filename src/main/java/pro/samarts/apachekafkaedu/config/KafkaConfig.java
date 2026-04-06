package pro.samarts.apachekafkaedu.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic educationTopic() {

        // Create a topic named "messages-topic" with 3 partitions
        return TopicBuilder.name("messages-topic")
                .partitions(3)
                .replicas(1) // Only 1 replica since we have only 1 broker in Docker
                .build();
    }
}
