package com.adoc.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdocApiResponse<T> {
    private static final String SUCCESS_STATUS = "success";
    private static final String FAIL_STATUS = "fail";

    private final String status;
    private final String message;
    private final T data;

    private AdocApiResponse(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static AdocApiResponse<Void> successWithNoContent() {
        return new AdocApiResponse<>(SUCCESS_STATUS, null, null);
    }

}
