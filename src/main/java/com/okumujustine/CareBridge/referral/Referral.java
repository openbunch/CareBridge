package com.okumujustine.CareBridge.referral;
import com.okumujustine.CareBridge.healthfacility.HealthFacility;
import com.okumujustine.CareBridge.referral.enums.ReferralPriority;
import com.okumujustine.CareBridge.referral.enums.ReferralStatus;
import com.okumujustine.CareBridge.referral.enums.ReferralType;
import com.okumujustine.CareBridge.patient.Patient;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;

@Entity
@Table(name = "referrals")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Referral {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "from_facility_id")
    private HealthFacility fromFacility;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "to_facility_id")
    private HealthFacility toFacility;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReferralType referralType;

    @Column(nullable = false)
    private String serviceLine;

    @Column(nullable = false, length = 1000)
    private String reason;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReferralPriority priority;

    @Column(length = 2000)
    private String notes;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReferralStatus status = ReferralStatus.PENDING;

    @CreationTimestamp
    private OffsetDateTime requestedAt;

    private OffsetDateTime scheduledAt;
    private OffsetDateTime completedAt;
}
