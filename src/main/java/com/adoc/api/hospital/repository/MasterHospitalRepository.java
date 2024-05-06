package com.adoc.api.hospital.repository;

import com.adoc.api.hospital.domain.MasterHospital;
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
            "    COUNT(HR.hospital_id) AS reviewCount " +
            "FROM master_hospitals MH " +
            "LEFT JOIN hospital_reviews HR ON MH.hospital_id = HR.hospital_id " +
            "WHERE (:isNightService IS NULL OR MH.is_night_service = :isNightService) " +
            "AND (:isSaturdayService IS NULL OR MH.is_saturday_service = :isSaturdayService) " +
            "AND (:isPublicNoninsuredCost IS NULL OR MH.is_public_noninsured_cost = :isPublicNoninsuredCost) " +
            "GROUP BY " +
            "    MH.is_night_service, " +
            "    MH.is_saturday_service, " +
            "    MH.is_public_noninsured_cost, " +
            "    MH.hospital_rating, " +
            "    MH.hospital_name, " +
            "    MH.hospital_address " +
            "ORDER BY " +
            "    CASE WHEN :sortByClause = 'hospitalRating DESC' THEN hospitalRating END DESC, " +
            "    CASE WHEN :sortByClause = 'reviewCount DESC' THEN reviewCount END DESC", nativeQuery = true)
    List<Object[]> getHospitalList(Boolean isNightService, Boolean isSaturdayService, Boolean isPublicNoninsuredCost, String sortByClause);
}
