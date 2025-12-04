package com.okumujustine.CareBridge.patient;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientExternalIdRepository extends JpaRepository<PatientExternalId, String> {

    Optional<PatientExternalId> findByFacilityIdAndExternalPatientId(String facilityId, String externalPatientId);
}

