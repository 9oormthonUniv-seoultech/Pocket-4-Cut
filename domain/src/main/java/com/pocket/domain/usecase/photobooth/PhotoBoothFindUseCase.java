package com.pocket.domain.usecase.photobooth;

import com.pocket.domain.dto.photobooth.NearPhotoBoothInfo;
import com.pocket.domain.dto.photobooth.PhotoBoothFindResponseDto;
import com.pocket.domain.entity.photobooth.PhotoBoothBrand;

import java.util.List;

public interface PhotoBoothFindUseCase {

    PhotoBoothFindResponseDto getPhotoBoothFindResponse(Long id);

    List<NearPhotoBoothInfo> findNearPhotoBooth(double lat, double lon, PhotoBoothBrand brand);

}
