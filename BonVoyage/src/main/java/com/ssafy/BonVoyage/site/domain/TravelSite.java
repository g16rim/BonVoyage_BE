package com.ssafy.BonVoyage.site.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TravelSite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "site_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @ColumnDefault("0")
    private int type;

    @Column
    private String sitePictureUrl;

    @Column(nullable = false)
    private String phone;

    @Lob
    private String content;

    @Column(nullable = false)
    @ColumnDefault("0.0")
    private double rating;

    @Column(nullable = false)
    @ColumnDefault("0")
    private int dibCount;

    @Column(nullable = false)
    @ColumnDefault("0")
    private int reviewCount;

    private String operatingHours;

    private String closedDays;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    private double latitude;

    private double longitude;

}

