package io.confluent.developer.twitterconversationconsumer.repository;

import io.confluent.developer.twitterconversationconsumer.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TwitterRepository extends JpaRepository<Tweet, String> {
}
