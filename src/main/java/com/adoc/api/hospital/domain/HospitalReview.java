package com.adoc.api.hospital.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "hospital_reviews")
public class HospitalReview {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID")
    @Column(name = "hospital_review_id", updatable = false, nullable = false)
    private UUID reviewId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id")
    private MasterHospital hospital;

    @Column(name = "review_platform", nullable = false, length = 10)
    private String platform;

    @Column(name = "review_content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "review_nickname", length = 100)
    private String nickname;

    @Column(name = "review_score", columnDefinition = "FLOAT")
    private Float score;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "last_modified_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedAt;
}
