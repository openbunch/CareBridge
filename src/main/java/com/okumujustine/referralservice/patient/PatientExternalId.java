package com.okumujustine.referralservice.patient;
import com.okumujustine.referralservice.healthfacility.HealthFacility;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "patient_external_ids",
        uniqueConstraints = @UniqueConstraint(
                name = "uk_patient_externalid_facility",
                columnNames = {"facility_id", "external_patient_id"}
        )
)
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class PatientExternalId {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "facility_id")
    private HealthFacility facility;

    @Column(name = "external_patient_id", nullable = false)
    private String externalPatientId;

    private String idType;
}

