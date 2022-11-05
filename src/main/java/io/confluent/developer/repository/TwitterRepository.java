package io.confluent.developer.repository;

import io.confluent.developer.model.TweetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TwitterRepository extends JpaRepository<TweetEntity, String> {
}
