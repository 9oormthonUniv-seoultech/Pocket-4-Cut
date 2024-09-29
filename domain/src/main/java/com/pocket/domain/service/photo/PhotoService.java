package com.pocket.domain.service.photo;

import com.pocket.domain.dto.photo.PhotoRegisterRequestDto;
import com.pocket.domain.port.photo.PhotoRegisterPort;
import com.pocket.domain.usecase.photo.PhotoRegisterUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhotoService implements PhotoRegisterUseCase {

    private final PhotoRegisterPort photoRegisterPort;

    public String registerPhotoResponse(PhotoRegisterRequestDto photoRegisterRequestDto) {
        return photoRegisterPort.registerPhoto(photoRegisterRequestDto);
    }

}
