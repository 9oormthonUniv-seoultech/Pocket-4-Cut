package com.pocket.outbound.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "image_hashtag_map")
public class JpaPhotoHashtag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photo_hashtag_map_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "image_id")
    private JpaPhoto jpaPhoto;

    @ManyToOne
    @JoinColumn(name = "hashtag_id")
    private JpaHashtag jpaHashtag;

    @Builder
    private JpaPhotoHashtag(JpaHashtag jpaHashtag, JpaPhoto jpaPhoto) {
        this.jpaHashtag = jpaHashtag;
        this.jpaPhoto = jpaPhoto;
    }

}
