package com.pocket.domain.dto.photo;

public record PhotoRegisterRequestDto(
        String shootingDate,
        String location,
        String[] hashtags,
        String record,
        String imageName, // 이미지 이름
        String prefix // S3 버킷 내에 저장할 경로
) {}
