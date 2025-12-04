package com.okumujustine.CareBridge.healthfacility;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "health_facilities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HealthFacility {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private HealthFacilityType type;

    private String country;
    private String region;
    private String district;
    private String city;
}
