package com.pocket.outbound.repository;

import com.pocket.outbound.entity.JpaHashtag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HashtagRepository extends JpaRepository<JpaHashtag, Long> {
}
