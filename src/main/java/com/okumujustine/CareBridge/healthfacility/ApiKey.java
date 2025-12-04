package com.okumujustine.CareBridge.healthfacility;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "api_keys")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiKey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String keyValue;

    @ManyToOne(optional = false)
    private HealthFacility facility;
}
