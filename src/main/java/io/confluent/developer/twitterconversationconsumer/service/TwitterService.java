package io.confluent.developer.twitterconversationconsumer.service;

import io.confluent.developer.twitterconversationconsumer.model.Tweet;
import io.confluent.developer.twitterconversationconsumer.repository.TwitterRepository;

public class TwitterService {

    private TwitterRepository twitterRepository;

    public TwitterService(TwitterRepository twitterRepository){
        this.twitterRepository = twitterRepository;
    }

    public Tweet saveTweet(Tweet tweetRecord) {
        Tweet tweet = Tweet.builder()
                .id(tweetRecord.getId())
                .conversation_id(tweetRecord.getConversation_id())
                .created_at(tweetRecord.getCreated_at())
                .author_id(tweetRecord.getAuthor_id())
                .text(tweetRecord.getText())
                .possibly_sensitive(tweetRecord.isPossibly_sensitive())
                .build();
        return twitterRepository.save(tweet);
    }
}
