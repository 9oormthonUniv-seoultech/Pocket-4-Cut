package com.pocket.domain.port.photo;

import com.pocket.domain.dto.photo.PhotoRegisterRequestDto;
import com.pocket.domain.dto.photobooth.PhotoBoothFindResponseDto;

public interface PhotoRegisterPort {

    String registerPhoto(PhotoRegisterRequestDto photoRegisterRequestDto);

}
