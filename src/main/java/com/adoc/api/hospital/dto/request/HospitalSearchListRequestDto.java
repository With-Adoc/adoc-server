package com.adoc.api.hospital.dto.request;

import com.adoc.api.common.dto.PaginationDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

@Getter
@Setter
public class HospitalSearchListRequestDto extends PaginationDto {
    private String search;
    private SortBy sortBy = SortBy.RATING_DESC; // 기본 정렬값

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
