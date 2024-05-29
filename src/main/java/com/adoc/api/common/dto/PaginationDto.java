package com.adoc.api.common.dto;

import lombok.Getter;
import lombok.Setter;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@Schema(description = "Pagination information")
public class PaginationDto {
    @Schema(description = "Page number", example = "0", required = true, defaultValue = "0")
    int pageNumber = 0;
    @Schema(description = "Page size", example = "30", required = true, defaultValue = "30")
    int pageSize = 30;
}
