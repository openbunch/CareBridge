package com.okumujustine.referralservice.healthfacility;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class FacilityRequestContext {

    private HealthFacility facility;

    public HealthFacility getFacility() {
        return facility;
    }

    public void setFacility(HealthFacility facility) {
        this.facility = facility;
    }

    public String getFacilityId() {
        return facility != null ? facility.getId() : null;
    }
}

