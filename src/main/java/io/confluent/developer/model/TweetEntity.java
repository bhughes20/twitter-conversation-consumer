package io.confluent.developer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conversation_tweets")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TweetEntity {
    @Id
    private String id;
    private String conversation_id;
    private String created_at;
    private String author_id;
    @Column(length=1000)
    private String text;
    private boolean possibly_sensitive;
}