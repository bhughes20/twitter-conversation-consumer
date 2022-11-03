package io.confluent.developer.twitterconversationconsumer.service;

import io.confluent.developer.avro.Tweet;
import io.confluent.developer.twitterconversationconsumer.model.TweetEntity;
import io.confluent.developer.twitterconversationconsumer.repository.TwitterRepository;
import org.springframework.stereotype.Service;

@Service
public class TwitterService {

    private TwitterRepository twitterRepository;

    public TwitterService(TwitterRepository twitterRepository){
        this.twitterRepository = twitterRepository;
    }

    public TweetEntity saveTweet(Tweet tweetRecord) {
        TweetEntity tweetEntity = TweetEntity.builder()
                .id(String.valueOf(tweetRecord.getId()))
                .conversation_id(String.valueOf(tweetRecord.getConversationId()))
                .created_at(String.valueOf(tweetRecord.getCreatedAt()))
                .author_id(String.valueOf(tweetRecord.getAuthorId()))
                .text(String.valueOf(tweetRecord.getText()))
                .possibly_sensitive(tweetRecord.getPossiblySensitive())
                .build();
        return twitterRepository.save(tweetEntity);
    }
}
