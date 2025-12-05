package com.okumujustine.referralservice.patient;

import com.okumujustine.referralservice.healthfacility.FacilityRequestContext;
import com.okumujustine.referralservice.healthfacility.HealthFacility;
import com.okumujustine.referralservice.patient.dtos.PatientCreateRequest;
import com.okumujustine.referralservice.patient.dtos.PatientResponse;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final PatientExternalIdRepository externalIdRepository;
    private final FacilityRequestContext facilityRequestContext;


    @Transactional
    public PatientResponse getOrCreatePatient(PatientCreateRequest req) {

        HealthFacility currentFacility = facilityRequestContext.getFacility();
        if (currentFacility == null) {
            throw new IllegalStateException("Facility not resolved from API key");
        }

        // Try to find patient by facilityId and externalId
        var mappingOpt = externalIdRepository.findByFacilityIdAndExternalPatientId(
                currentFacility.getId(),
                req.getExternalPatientId()
        );

        if (mappingOpt.isPresent()) {
            // Return existing patient if exists
            return toResponse(mappingOpt.get().getPatient());
        }

        // Check date of birth format
        LocalDate dob = null;
        if (req.getDateOfBirth() != null && !req.getDateOfBirth().isBlank()) {
            try {
                dob = LocalDate.parse(req.getDateOfBirth());
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Invalid dateOfBirth format; expected ISO-8601 (e.g. 1990-04-02)");
            }
        }

        // Create new patient
        var patient = Patient.builder()
                .fullName(req.getFullName())
                .gender(req.getGender())
                .dateOfBirth(dob)
                .phone(req.getPhone())
                .build();

        patient = patientRepository.save(patient);

        // 4. Create mapping row
        var mapping = PatientExternalId.builder()
                .patient(patient)
                .facility(currentFacility)
                .externalPatientId(req.getExternalPatientId())
                .idType("EMR_PATIENT_ID")
                .build();

        externalIdRepository.save(mapping);

        return toResponse(patient);
    }

    /**
     * Get a patient by internal platform ID.
     */
    public PatientResponse getById(String patientId) {
        var patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found"));
        return toResponse(patient);
    }

    private PatientResponse toResponse(Patient patient) {
        return PatientResponse.builder()
                .id(patient.getId())
                .fullName(patient.getFullName())
                .gender(patient.getGender())
                .dateOfBirth(patient.getDateOfBirth() != null ? patient.getDateOfBirth().toString() : null)
                .phone(patient.getPhone())
                .build();
    }
}
