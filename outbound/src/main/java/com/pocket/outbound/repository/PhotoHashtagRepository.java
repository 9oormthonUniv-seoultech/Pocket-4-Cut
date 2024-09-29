package com.pocket.outbound.repository;

import com.pocket.outbound.entity.JpaPhotoHashtag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoHashtagRepository extends JpaRepository<JpaPhotoHashtag, Long> {

    // 나중에 검색할 때 이거 가져다 쓰기!
    List<JpaPhotoHashtag> findByJpaPhotoId(Long imageId);
    List<JpaPhotoHashtag> findByJpaHashtagId(Long hashtagId);
}
