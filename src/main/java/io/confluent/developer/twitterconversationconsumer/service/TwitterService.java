package io.confluent.developer.twitterconversationconsumer.service;

import io.confluent.developer.twitterconversationconsumer.model.Tweet;
import io.confluent.developer.twitterconversationconsumer.repository.TwitterRepository;
import io.confluent.ksql.avro_schemas.KsqlDataSourceSchema;

public class TwitterService {

    private TwitterRepository twitterRepository;

    public TwitterService(TwitterRepository twitterRepository){
        this.twitterRepository = twitterRepository;
    }

    public Tweet saveTweet(KsqlDataSourceSchema tweetRecord) {
        Tweet tweet = Tweet.builder()
                .id(tweetRecord.getID())
                .conversation_id(tweetRecord.getCONVERSATIONID())
                .created_at(tweetRecord.getCREATEDAT())
                .author_id(tweetRecord.getAUTHORID())
                .text(tweetRecord.getTEXT())
                .possibly_sensitive(tweetRecord.getPOSSIBLYSENSITIVE())
                .build();
        return twitterRepository.save(tweet);
    }
}
