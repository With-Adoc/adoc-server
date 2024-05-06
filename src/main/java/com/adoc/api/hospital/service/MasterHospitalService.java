package com.adoc.api.hospital.service;

import com.adoc.api.hospital.dto.HospitalListRequestDto;
import com.adoc.api.hospital.dto.HospitalListResponseDto;
import com.adoc.api.hospital.repository.MasterHospitalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class MasterHospitalService {
    private final MasterHospitalRepository hospitalRepository;

    public MasterHospitalService(MasterHospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public List<HospitalListResponseDto> getHospitalList(HospitalListRequestDto hospitalListRequestDto) {
        String sortByClause = buildSortByClause(hospitalListRequestDto.getSortBy());
        List<Object[]> results = hospitalRepository.getHospitalList(
                hospitalListRequestDto.getIsNightService(),
                hospitalListRequestDto.getIsSaturdayService(),
                hospitalListRequestDto.getIsPublicNoninsuredCost(),
                sortByClause
        );

        return results.stream().map(this::mapToHospitalListDto).collect(Collectors.toList());
    }

    private String buildSortByClause(HospitalListRequestDto.SortBy sortBy) {
        if (sortBy == null) {
            return "";
        }
        return sortBy == HospitalListRequestDto.SortBy.RATING_DESC ? "hospitalRating DESC" : "reviewCount DESC";
    }

    private HospitalListResponseDto mapToHospitalListDto(Object[] result) {
        HospitalListResponseDto dto = new HospitalListResponseDto();
        dto.setIsNightService((result[0] != null && (int) result[0] == 1));
        dto.setIsSaturdayService((result[0] != null && (int) result[1] == 1));
        dto.setIsPublicNoninsuredCost((result[0] != null && (int) result[2] == 1));
        dto.setHospitalRating((int) result[3]);
        dto.setHospitalName((String) result[4]);
        dto.setHospitalAddress((String) result[5]);
        dto.setReviewCount((result[6] != null ? ((Number) result[6]).intValue() : 0));
        return dto;
    }
}
