package com.pocket.outbound.adapter.photo;


import com.pocket.core.image.dto.PresignedUrlResponse;
import com.pocket.core.image.service.FileService;
import com.pocket.domain.dto.photo.PhotoRegisterRequestDto;
import com.pocket.domain.port.photo.PhotoRegisterPort;
import com.pocket.outbound.entity.JpaHashtag;
import com.pocket.outbound.entity.JpaPhotoHashtag;
import com.pocket.outbound.entity.JpaPhoto;
import com.pocket.outbound.repository.HashtagRepository;
import com.pocket.outbound.repository.PhotoHashtagRepository;
import com.pocket.outbound.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhotoAdapter implements PhotoRegisterPort {

    private final PhotoRepository photoRepository;
    private final HashtagRepository hashtagRepository;
    private final PhotoHashtagRepository photoHashtagRepository;
    private final FileService fileService;

    @Override
    public String registerPhoto(PhotoRegisterRequestDto dto) {

        // presigned Url과 파일 경로 발급
        String imageName = dto.imageName();
        String prefix = dto.prefix();
        PresignedUrlResponse response = fileService.getUploadPresignedUrl(prefix, imageName);
        String presignedUrl = response.getUrl();
        String filePath = response.getFilePath();

        // dto를 entity로 변환
        JpaPhoto photoEntity = JpaPhoto.builder()
                .shootingDate(dto.shootingDate())
                .location(dto.location())
                .record(dto.record())
                .imageUrl(filePath)
                .build();

        photoRepository.save(photoEntity);

        for (String hashtag : dto.hashtags()) {
            JpaHashtag hashtagEntity = JpaHashtag.builder()
                    .name(hashtag)
                    .build();
            JpaPhotoHashtag imageHashtagEntity = JpaPhotoHashtag.builder()
                    .jpaPhoto(photoEntity)
                    .jpaHashtag(hashtagEntity)
                    .build();
            hashtagRepository.save(hashtagEntity);
            photoHashtagRepository.save(imageHashtagEntity);
        }

        return presignedUrl; // presigned Url 반환
    }
}
