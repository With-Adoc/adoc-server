package com.adoc.api.common.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginationDto {
    int pageNumber;
    int pageSize;
}
