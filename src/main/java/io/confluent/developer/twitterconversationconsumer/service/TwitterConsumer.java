package io.confluent.developer.twitterconversationconsumer.service;

import io.confluent.ksql.avro_schemas.KsqlDataSourceSchema;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TwitterConsumer {

    private TwitterService twitterService;

    public TwitterConsumer(TwitterService twitterService) {
        this.twitterService = twitterService;
    }

    @KafkaListener(id = "#{'${group.id}'}", topics = "#{'${input.topic.name}'}")
    public void consume(final ConsumerRecord<String, KsqlDataSourceSchema> tweetRecord){
        KsqlDataSourceSchema tweetRecord2 = tweetRecord.value();
        System.out.println(tweetRecord2.getID());
//        twitterService.saveTweet(tweetRecord.value());
        System.out.println(String.format("Consumed event from topic %s: key = %-10s value = %s", tweetRecord.topic(), tweetRecord.key(), tweetRecord.value()));
    }
}
