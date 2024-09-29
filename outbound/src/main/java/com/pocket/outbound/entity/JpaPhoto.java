package com.pocket.outbound.entity;

import com.pocket.domain.entity.image.Image;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.parameters.P;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.pocket.domain.entity.image.ImageType.PHOTO;

@Getter
@NoArgsConstructor
@Table(name = "IMAGE")
@Entity
public class JpaPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long id;

    @Embedded
    private Image image;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private JpaUser jpaUser;

    @ManyToOne
    @JoinColumn(name = "photobooth_id")
    private JpaPhotoBooth jpaPhotoBooth;

    private LocalDate shootingDate;

    private String location;

    private String record;

    // 1. image url도 넣어야함 -> 완료
    // 2. user id도 넣어야함
    // 3. photobooth id도 넣어야함
    @Builder
    private JpaPhoto(String shootingDate, String location, String record, String imageUrl) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        this.shootingDate = LocalDate.parse(shootingDate, formatter);
        this.location = location;
        this.record = record;
        this.image = new Image(PHOTO, imageUrl);
    }

}
