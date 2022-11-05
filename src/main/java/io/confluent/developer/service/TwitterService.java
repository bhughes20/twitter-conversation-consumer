package io.confluent.developer.service;

import io.confluent.developer.avro.Tweet;
import io.confluent.developer.model.TweetEntity;
import io.confluent.developer.repository.TwitterRepository;
import org.springframework.stereotype.Service;

@Service
public class TwitterService {

    private TwitterRepository twitterRepository;

    public TwitterService(TwitterRepository twitterRepository){
        this.twitterRepository = twitterRepository;
    }

    public TweetEntity saveTweet(Tweet tweetRecord) {
        TweetEntity tweetEntity = TweetEntity.builder()
                .id(tweetRecord.getId())
                .conversation_id(tweetRecord.getConversationId())
                .created_at(tweetRecord.getCreatedAt())
                .author_id(tweetRecord.getAuthorId())
                .text(tweetRecord.getText())
                .possibly_sensitive(tweetRecord.getPossiblySensitive())
                .build();
        return twitterRepository.save(tweetEntity);
    }
}
