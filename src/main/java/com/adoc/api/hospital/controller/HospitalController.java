package com.adoc.api.hospital.controller;

import com.adoc.api.hospital.dto.HospitalListRequestDto;
import com.adoc.api.hospital.dto.HospitalListResponseProjection;
import com.adoc.api.hospital.service.MasterHospitalService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<HospitalListResponseProjection>> getHospitalList(HospitalListRequestDto hospitalListRequestDto) {
        return ResponseEntity.ok(hospitalService.getHospitalList(hospitalListRequestDto));
    }
}
