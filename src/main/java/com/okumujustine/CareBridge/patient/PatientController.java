package com.okumujustine.CareBridge.patient;

import com.okumujustine.CareBridge.patient.dtos.PatientCreateRequest;
import com.okumujustine.CareBridge.patient.dtos.PatientResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/patients")
@RequiredArgsConstructor
@Tag(name = "Patients", description = "Patient registration and lookup APIs")
@SecurityRequirement(name = "ApiKeyAuth") // uses the scheme defined in OpenApiConfig
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    @Operation(
            summary = "Create or resolve patient",
            description = """
                    Creates a new patient for the current health facility based on externalPatientId, 
                    or returns the existing patient if that externalPatientId is already registered 
                    for this facility.
                    """
    )
    public PatientResponse createOrResolvePatient(
            @Valid @RequestBody PatientCreateRequest request
    ) {
        return patientService.getOrCreatePatient(request);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get patient by platform ID",
            description = "Returns a patient by internal platform patient ID (if the current facility has access)."
    )
    public PatientResponse getPatientById(
            @PathVariable String id
    ) {
        return patientService.getById(id);
    }
}
