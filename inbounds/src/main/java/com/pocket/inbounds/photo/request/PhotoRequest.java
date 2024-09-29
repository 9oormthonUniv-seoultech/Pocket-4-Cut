package com.pocket.inbounds.photo.request;

public record PhotoRequest(
        String shootingDate,
        String location,
        String[] hashtags,
        String record,
        String imageName,
        String prefix
) {}
