package com.adoc.api.hospital.dto.request;

import com.adoc.api.common.dto.PaginationDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

import java.util.UUID;

@Getter
@Setter
public class HospitalReviewListRequestDto extends PaginationDto {
    private UUID uuid;
    private SortBy sortBy = SortBy.SCORE_DESC; // 기본 정렬값

    public enum SortBy {
        SCORE_DESC(Sort.by(Sort.Direction.DESC, "score")),
        PLATFORM_ASC(Sort.by(Sort.Direction.ASC, "platform"));

        private Sort sortByClause;

        SortBy(Sort sortByClause) {
            this.sortByClause = sortByClause;
        }

        public Sort getSortByClause() {
            return sortByClause;
        }
    }
}
