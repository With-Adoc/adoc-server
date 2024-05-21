package com.adoc.api.hospital.repository;

import com.adoc.api.hospital.domain.MasterHospital;
import com.adoc.api.hospital.dto.HospitalListResponseProjectionDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface MasterHospitalRepository extends JpaRepository<MasterHospital, UUID> {
    @Query(value = "SELECT " +
            "    IFNULL(MH.is_night_service, FALSE) AS isNightService, " +
            "    IFNULL(MH.is_saturday_service, FALSE) AS isSaturdayService, " +
            "    IFNULL(MH.is_public_noninsured_cost, FALSE) AS isPublicNoninsuredCost, " +
            "    IFNULL(MH.hospital_rating, 0) AS hospitalRating, " +
            "    MH.hospital_name AS hospitalName, " +
            "    MH.hospital_address AS hospitalAddress, " +
            "    HR.reviewCount AS reviewCount, " +
            "    HI.hospital_image_url AS hospitalImageUrl " +
            "FROM master_hospitals MH " +
            "INNER JOIN hospital_images HI ON MH.hospital_id = HI.hospital_id " +
            "LEFT JOIN ( " +
            "    SELECT " +
            "          hospital_id " +
            "        , COUNT(*) as reviewCount " +
            "    FROM hospital_reviews " +
            "    GROUP BY hospital_id) HR " +
            "ON MH.hospital_id = HR.hospital_id " +
            "WHERE (:isNightService IS NULL OR MH.is_night_service = :isNightService)  " +
            "AND (:isSaturdayService IS NULL OR MH.is_saturday_service = :isSaturdayService)  " +
            "AND (:isPublicNoninsuredCost IS NULL OR MH.is_public_noninsured_cost = :isPublicNoninsuredCost)  ",
            countQuery = "SELECT COUNT(*) FROM master_hospitals",
            nativeQuery = true)
    List<HospitalListResponseProjectionDto> getHospitalList(Boolean isNightService, Boolean isSaturdayService, Boolean isPublicNoninsuredCost, Pageable pageable);

    @Query("SELECT isNightService AS isNightService,  \n" +
            "isSaturdayService AS isSaturdayService,  \n" +
            "isPublicNoninsuredCost AS isPublicNoninsuredCost, \n" +
            "rating AS hospitalRating, \n" +
            "name AS hospitalName, \n" +
            "address AS hospitalAddress \n" +
            "from MasterHospital " +
            "where name like CONCAT('%',:search,'%')" +
            "or address like CONCAT('%',:search,'%')")
    List<HospitalListResponseProjectionDto> findAllByNameLikeOrAddressLike(String search, Pageable pageable);


}
