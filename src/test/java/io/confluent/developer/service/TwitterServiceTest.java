package io.confluent.developer.service;

import io.confluent.developer.avro.Tweet;
import io.confluent.developer.repository.TwitterRepository;
import io.confluent.developer.model.TweetEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TwitterServiceTest {

    @Mock
    private TwitterRepository twitterRepository;
    @InjectMocks
    private TwitterService twitterService;
    @Test
    public void givenTweetRecordObject_whenSaveTweet_thenShouldReturnTweetObject(){
        //Arrange
        TweetEntity tweetEntity = TweetEntity.builder()
                .id("1050118621198921728")
                .conversation_id("1212092627178287104")
                .created_at("2022-11-02T23:12:08.000Z")
                .author_id("2244994945")
                .text("This is sample twitter text")
                .possibly_sensitive(false)
                .build();

        Tweet tweetRecord = Tweet.newBuilder()
                .setId("1050118621198921728")
                .setConversationId("1212092627178287104")
                .setAuthorId("2244994945")
                .setCreatedAt("2022-11-02T23:12:08.000Z")
                .setText("This is sample twitter text")
                .setPossiblySensitive(false)
                .build();

        when(twitterRepository.save(tweetEntity)).thenReturn(tweetEntity);
        //Act
        TweetEntity savedTweetEntity = twitterService.saveTweet(tweetRecord);
        //Assert
        assertThat(savedTweetEntity).isNotNull();
        assertEquals(savedTweetEntity.getId(), tweetRecord.getId());
    }

}
