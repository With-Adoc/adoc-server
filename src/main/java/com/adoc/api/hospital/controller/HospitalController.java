package com.adoc.api.hospital.controller;

import com.adoc.api.hospital.dto.request.HospitalListRequestDto;
import com.adoc.api.hospital.dto.HospitalListResponseProjectionDto;
import com.adoc.api.hospital.dto.HospitalReviewListResponseProjectionDto;
import com.adoc.api.hospital.dto.request.HospitalReviewListRequestDto;
import com.adoc.api.hospital.dto.request.HospitalSearchListRequestDto;
import com.adoc.api.hospital.service.MasterHospitalService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
    private final MasterHospitalService hospitalService;

    public HospitalController(MasterHospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<HospitalListResponseProjectionDto>> getHospitalList(@ParameterObject HospitalListRequestDto hospitalListRequestDto) {
        List<HospitalListResponseProjectionDto> hospitalList = hospitalService.getHospitalList(hospitalListRequestDto);
        return ResponseEntity.ok(hospitalList);
    }

    @GetMapping("/search")
    public ResponseEntity<List<HospitalListResponseProjectionDto>> getHospitalSearchList(@ParameterObject HospitalSearchListRequestDto hospitalListRequestDto) {
        List<HospitalListResponseProjectionDto> hospitalList = hospitalService.getHospitalSearchList(hospitalListRequestDto);
        return ResponseEntity.ok(hospitalList);
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<HospitalReviewListResponseProjectionDto>> getHospitalReviewList(@ParameterObject HospitalReviewListRequestDto hospitalListRequestDto) {
        List<HospitalReviewListResponseProjectionDto> hospitalList = hospitalService.getHospitalReviewList(hospitalListRequestDto);
        return ResponseEntity.ok(hospitalList);
    }
}
