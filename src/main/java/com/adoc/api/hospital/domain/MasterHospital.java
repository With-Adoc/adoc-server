package com.adoc.api.hospital.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "master_hospitals")
public class MasterHospital {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID")
    @Column(name = "hospital_id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "hospital_name", nullable = false, length = 255)
    private String name;

    @Column(name = "hospital_address", length = 255)
    private String address;

    @Column(name = "hospital_telephone", length = 20)
    private String telephone;

    @Column(name = "hospital_homepage", length = 255)
    private String homepage;

    @Column(name = "hospital_rating")
    private Integer rating;

    @Column(name = "is_night_service")
    private Boolean isNightService;

    @Column(name = "is_saturday_service")
    private Boolean isSaturdayService;

    @Column(name = "is_public_noninsured_cost")
    private Boolean isPublicNoninsuredCost;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "last_modified_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedAt;
}
