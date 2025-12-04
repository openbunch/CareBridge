package com.okumujustine.CareBridge.healthfacility;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HealthFacilityRepository extends JpaRepository<HealthFacility, String> {
}
