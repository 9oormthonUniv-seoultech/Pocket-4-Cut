package com.pocket.outbound.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "hashtag")
public class JpaHashtag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Builder
    public JpaHashtag(String name) {
        this.name = name;
    }
}
