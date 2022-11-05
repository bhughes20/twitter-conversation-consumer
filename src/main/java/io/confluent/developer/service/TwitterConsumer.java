package io.confluent.developer.service;

import io.confluent.developer.avro.Tweet;
import io.confluent.developer.model.TweetEntity;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TwitterConsumer {

    private TwitterService twitterService;

    public TwitterConsumer(TwitterService twitterService) {
        this.twitterService = twitterService;
    }

    @KafkaListener(id = "#{'${spring.kafka.consumer.group-id}'}", topics = "#{'${spring.kafka.consumer.properties.input.topic.name}'}")
    public void consume(final ConsumerRecord<String, Tweet> tweetRecord){
        TweetEntity savedTweet = twitterService.saveTweet(tweetRecord.value());
        System.out.println(String.format("Consumed event from topic %s: key = %-10s value = %s", tweetRecord.topic(), tweetRecord.key(), savedTweet.toString()));
    }
}
