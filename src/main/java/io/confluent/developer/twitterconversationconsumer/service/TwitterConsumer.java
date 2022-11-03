package io.confluent.developer.twitterconversationconsumer.service;

import io.confluent.developer.avro.Tweet;
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
    public void consume(final ConsumerRecord<String, Tweet> tweetRecord){
        /*
         The intention had been to pass in the avro Tweet Record to the TwitterService
         to save to repository and H2 database but java.lang.ClassCastException
         is occurring trying to convert the avro object to Tweet entity.

         As an alternative the avro serialized record is printed to console.
         */

//        twitterService.saveTweet(tweetRecord.value());
        System.out.println(String.format("Consumed event from topic %s: key = %-10s value = %s", tweetRecord.topic(), tweetRecord.key(), tweetRecord.value()));
    }
}
