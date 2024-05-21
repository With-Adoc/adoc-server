package com.adoc.api.hospital.service;

import com.adoc.api.hospital.dto.HospitalListRequestDto;
import com.adoc.api.hospital.dto.HospitalListResponseProjectionDto;
import com.adoc.api.hospital.repository.MasterHospitalRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasterHospitalService {
    private final MasterHospitalRepository hospitalRepository;

    public MasterHospitalService(MasterHospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public List<HospitalListResponseProjectionDto> getHospitalList(HospitalListRequestDto hospitalListRequestDto) {
        PageRequest pr = PageRequest.of(hospitalListRequestDto.getPageNumber(), hospitalListRequestDto.getPageSize(), hospitalListRequestDto.getSortBy().getSortByClause());

        return hospitalRepository.getHospitalList(
                hospitalListRequestDto.getIsNightService(),
                hospitalListRequestDto.getIsSaturdayService(),
                hospitalListRequestDto.getIsPublicNoninsuredCost(),
                pr
        );
    }

    public List<HospitalListResponseProjectionDto> getHospitalSearchList(HospitalListRequestDto hospitalListRequestDto) {
        PageRequest pr = PageRequest.of(hospitalListRequestDto.getPageNumber(), hospitalListRequestDto.getPageSize(), hospitalListRequestDto.getSortBy().getSortByClause());

        return hospitalRepository.findAllByNameLikeOrAddressLike(
                hospitalListRequestDto.getSearch(),
                pr
        );
    }
}
