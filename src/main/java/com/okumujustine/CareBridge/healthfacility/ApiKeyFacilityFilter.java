package com.okumujustine.CareBridge.healthfacility;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class ApiKeyFacilityFilter extends OncePerRequestFilter {

    private final ApiKeyRepository apiKeyRepository;
    private final FacilityRequestContext facilityRequestContext;

    public ApiKeyFacilityFilter(ApiKeyRepository apiKeyRepository,
                                FacilityRequestContext facilityRequestContext) {
        this.apiKeyRepository = apiKeyRepository;
        this.facilityRequestContext = facilityRequestContext;
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getRequestURI();

        // Allow Swagger UI and API docs
        if (path.startsWith("/swagger-ui")
                || path.equals("/swagger-ui.html")
                || path.startsWith("/v3/api-docs")) {
            return true;
        }

        // Allow facility creation WITHOUT API key (bootstrap)
        if (path.startsWith("/api/v1/facilities")
                && "POST".equalsIgnoreCase(request.getMethod())) {
            return true;
        }

        // Optionally allow health checks
        if (path.startsWith("/actuator/health")) {
            return true;
        }

        return false;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String apiKeyValue = request.getHeader("X-API-Key");

        if (apiKeyValue != null && !apiKeyValue.isBlank()) {
            apiKeyRepository.findByKeyValue(apiKeyValue)
                    .ifPresent(apiKey -> facilityRequestContext.setFacility(apiKey.getFacility()));
        }

        if (facilityRequestContext.getFacility() == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Missing or invalid API key");
            return;
        }

        filterChain.doFilter(request, response);
    }
}
