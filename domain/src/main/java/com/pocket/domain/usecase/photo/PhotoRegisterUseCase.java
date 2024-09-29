package com.pocket.domain.usecase.photo;

import com.pocket.domain.dto.photo.PhotoRegisterRequestDto;

public interface PhotoRegisterUseCase {

    String registerPhotoResponse(PhotoRegisterRequestDto photoRegisterRequestDto);

}
