package com.adoc.api.hospital.repository;

import com.adoc.api.hospital.domain.HospitalReview;
import com.adoc.api.hospital.dto.response.HospitalReviewListResponseProjectionDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface HospitalReviewRepository extends JpaRepository<HospitalReview, UUID> {

    @Query("SELECT " +
            "  HR.platform AS platform, " +
            "  HR.content AS content, " +
            "  HR.nickname AS nickname, " +
            "  HR.score AS score " +
            "FROM HospitalReview HR " +
            "WHERE HR.hospital.id = :uuid")
    List<HospitalReviewListResponseProjectionDto> findAllByHospitalId(UUID uuid, Pageable pageable);


}