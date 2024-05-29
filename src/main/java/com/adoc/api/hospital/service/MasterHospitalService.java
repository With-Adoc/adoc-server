package com.adoc.api.hospital.service;

import com.adoc.api.hospital.dto.request.HospitalListRequestDto;
import com.adoc.api.hospital.dto.response.HospitalListResponseProjectionDto;
import com.adoc.api.hospital.dto.response.HospitalReviewListResponseProjectionDto;
import com.adoc.api.hospital.dto.request.HospitalReviewListRequestDto;
import com.adoc.api.hospital.dto.request.HospitalSearchListRequestDto;
import com.adoc.api.hospital.repository.HospitalReviewRepository;
import com.adoc.api.hospital.repository.MasterHospitalRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MasterHospitalService {

    private final MasterHospitalRepository hospitalRepository;
    private final HospitalReviewRepository reviewRepository;

    public List<HospitalListResponseProjectionDto> getHospitalList(HospitalListRequestDto hospitalListRequestDto) {
        PageRequest pr = PageRequest.of(hospitalListRequestDto.getPageNumber(), hospitalListRequestDto.getPageSize(), hospitalListRequestDto.getSortBy().getSortByClause());

        return hospitalRepository.getHospitalList(
                hospitalListRequestDto.getIsNightService(),
                hospitalListRequestDto.getIsSaturdayService(),
                hospitalListRequestDto.getIsPublicNoninsuredCost(),
                pr
        );
    }

    public List<HospitalListResponseProjectionDto> getHospitalSearchList(HospitalSearchListRequestDto hospitalListRequestDto) {
        PageRequest pr = PageRequest.of(hospitalListRequestDto.getPageNumber(), hospitalListRequestDto.getPageSize(), hospitalListRequestDto.getSortBy().getSortByClause());

        return hospitalRepository.findAllByNameLikeOrAddressLike(
                hospitalListRequestDto.getSearch(),
                pr
        );
    }

    public List<HospitalReviewListResponseProjectionDto> getHospitalReviewList(HospitalReviewListRequestDto hospitalReviewListRequestDto) {
        PageRequest pr = PageRequest.of(hospitalReviewListRequestDto.getPageNumber(), hospitalReviewListRequestDto.getPageSize(), hospitalReviewListRequestDto.getSortBy().getSortByClause());

        return reviewRepository.findAllByHospitalId(
                hospitalReviewListRequestDto.getUuid(),
                pr
        );
    }
}
