package io.confluent.developer.twitterconversationconsumer.service;

import io.confluent.developer.twitterconversationconsumer.model.Tweet;
import io.confluent.developer.twitterconversationconsumer.repository.TwitterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class TwitterServiceTest {

    private TwitterRepository twitterRepository;
    private TwitterService twitterService;
    @Test
    public void givenTweetRecordObject_whenSaveTweet_thenShouldReturnTweetObject(){

        Tweet tweet = Tweet.builder()
                .id("1050118621198921728")
                .conversation_id("1212092627178287104")
                .created_at("2022-11-02T23:12:08.000Z")
                .author_id("2244994945")
                .text("This is sample twitter text")
                .possibly_sensitive(false)
                .build();

        twitterService = new TwitterService(twitterRepository);
        Tweet savedTweet = twitterService.saveTweet(tweet);

        assertThat(savedTweet).isNotNull();
    }

}
