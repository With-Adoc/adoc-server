package com.adoc.api.hospital.dto;

import com.adoc.api.common.dto.PaginationDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

@Getter
@Setter
public class HospitalListRequestDto extends PaginationDto {
    private String search;
    private Boolean isNightService;
    private Boolean isSaturdayService;
    private Boolean isPublicNoninsuredCost;
    private SortBy sortBy;

    public enum SortBy {
        RATING_DESC(Sort.by(Sort.Direction.DESC, "hospitalRating")),
        REVIEW_COUNT_DESC(Sort.by(Sort.Direction.DESC, "reviewCount"));

        private Sort sortByClause;

        SortBy(Sort sortByClause) {
            this.sortByClause = sortByClause;
        }

        public Sort getSortByClause() {
            return sortByClause;
        }
    }
}
