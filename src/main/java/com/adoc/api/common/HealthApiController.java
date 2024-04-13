package com.adoc.api.common;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthApiController {

    @GetMapping("/health")
    public AdocApiResponse<Void> healthCheck() {
        return AdocApiResponse.successWithNoContent();
    }

}
