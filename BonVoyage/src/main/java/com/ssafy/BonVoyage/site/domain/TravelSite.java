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
@Table(name = "travel_site")
public class TravelSite {

    @Id
    @Column(name = "site_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private int type;

    @Column
    private String image;

    @Column
    private String tel;

    @Column
    @ColumnDefault("0.0")
    private double rating;

    @Column(name = "dib_count")
    @ColumnDefault("0")
    private int dibCount;

    @Column(name = "review_count")
    @ColumnDefault("0")
    private int reviewCount;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @Column
    private double latitude;

    @Column
    private double longitude;

    @Column
    private String address;

    @Column
    private int areaCode;

}

