package com.pocket.inbounds.photo.presentation;

import com.pocket.core.exception.common.ApplicationResponse;
import com.pocket.domain.dto.photo.PhotoRegisterRequestDto;
import com.pocket.domain.usecase.photo.PhotoRegisterUseCase;
import com.pocket.inbounds.photo.request.PhotoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/photo")
public class PhotoController implements PhotoControllerDocs {

    private final PhotoRegisterUseCase photoRegisterUseCase;

    @PostMapping
    public ApplicationResponse<String> postPhoto(@RequestBody PhotoRequest photoRequest) {

        // 여기서 request를 dto로 변환
        PhotoRegisterRequestDto dto = new PhotoRegisterRequestDto(
                photoRequest.shootingDate(),
                photoRequest.location(),
                photoRequest.hashtags(),
                photoRequest.record(),
                photoRequest.imageName(),
                photoRequest.prefix()
        );

        String url = photoRegisterUseCase.registerPhotoResponse(dto);
        return ApplicationResponse.ok(url);// presigned Url을 리턴해줘야 함.
    }

}