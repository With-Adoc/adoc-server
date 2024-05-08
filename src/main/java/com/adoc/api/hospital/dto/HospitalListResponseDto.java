package com.adoc.api.hospital.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HospitalListResponseDto {
    private Boolean isNightService;
    private Boolean isSaturdayService;
    private Boolean isPublicNoninsuredCost;
    private int hospitalRating;
    private String hospitalName;
    private String hospitalAddress;
    private int reviewCount;
}
