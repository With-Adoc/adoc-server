package com.adoc.api.hospital.dto;

import org.springframework.beans.factory.annotation.Value;

public interface HospitalReviewListResponseProjectionDto {
    String getPlatform();
    String getContent();
    String getNickname();
    Float getScore();
}
