package com.adoc.api.hospital.dto.response;

import org.springframework.beans.factory.annotation.Value;

public interface HospitalListResponseProjectionDto {
    String getHospitalId();
    @Value("#{target.isNightService == 1}")
    Boolean getIsNightService();
    @Value("#{target.isSaturdayService == 1}")
    Boolean getIsSaturdayService();
    @Value("#{target.isPublicNoninsuredCost == 1}")
    Boolean getIsPublicNoninsuredCost();
    Integer getHospitalRating();
    String getHospitalName();
    String getHospitalAddress();
    Integer getReviewCount();
    String getHospitalImageUrl();
}
