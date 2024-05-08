package com.adoc.api.hospital.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HospitalListRequestDto {
    private Boolean isNightService;
    private Boolean isSaturdayService;
    private Boolean isPublicNoninsuredCost;
    private SortBy sortBy;

    public enum SortBy {
        RATING_DESC,
        REVIEW_COUNT_DESC
    }
}
