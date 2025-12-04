# CareBridge

CareBridge is a medical infrastructure platform designed to facilitate healthcare management across multiple health facilities. It enables patient registration, tracking, and referrals between different healthcare providers.

## Overview

CareBridge provides a RESTful API for managing:
- **Health Facilities**: Register and manage hospitals, clinics, and other healthcare providers
- **Patients**: Create and track patient records across facilities
- **Referrals**: Coordinate patient referrals between healthcare facilities

## Technology Stack

- **Java 21**: Programming language
- **Spring Boot 4.0.0**: Application framework
- **Spring Data JPA**: Data persistence
- **PostgreSQL**: Database
- **Lombok**: Reduce boilerplate code
- **OpenAPI/Swagger**: API documentation
- **Maven**: Build and dependency management

## Prerequisites

Before running CareBridge, ensure you have the following installed:

- Java 21 or higher
- PostgreSQL database
- Maven 3.6+ (or use included Maven wrapper)

## Database Setup

1. Create a PostgreSQL database (the default database name is `carbridge`):
```bash
createdb carbridge
```

2. Update the database configuration in `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/carbridge
spring.datasource.username=your_username
spring.datasource.password=your_password
```

## Installation & Running

1. Clone the repository:
```bash
git clone https://github.com/openbunch/CareBridge.git
cd CareBridge
```

2. Build the project:
```bash
./mvnw clean install
```

3. Run the application:
```bash
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`

## API Documentation

Once the application is running, you can access the interactive API documentation at:

- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **OpenAPI JSON**: http://localhost:8080/v3/api-docs

## API Authentication

CareBridge uses API key authentication via the `X-API-Key` header. To use the API:

1. Create a health facility to receive an API key:
```bash
POST /api/v1/facilities
```

2. Include the API key in subsequent requests:
```bash
X-API-Key: your-api-key-here
```

## Key Features

### Health Facility Management
- Register new health facilities in the CareBridge network
- Generate API keys for facility authentication
- Support for various facility types (hospitals, clinics, health centers)

### Patient Management
- Create or resolve patients by external facility IDs
- Track patients across multiple facilities
- Store patient demographics and contact information
- Prevent duplicate patient records within a facility

### Referral System
- Coordinate patient referrals between facilities
- Track referral status and priority
- Support different referral types

## Project Structure

```
src/main/java/com/okumujustine/CareBridge/
├── CareBridgeApplication.java       # Application entry point
├── config/                           # Configuration classes
│   └── OpenApiConfig.java           # API documentation configuration
├── healthfacility/                   # Health facility management
│   ├── HealthFacilityController.java
│   ├── HealthFacilityService.java
│   └── dtos/
├── patient/                          # Patient management
│   ├── PatientController.java
│   ├── PatientService.java
│   └── dtos/
├── referral/                         # Referral system
│   └── enums/
└── common/                          # Shared utilities and enums
```

## Contributing

Contributions are welcome! Please feel free to submit issues and pull requests.

## License

This project is open source and available under the specified license terms.
