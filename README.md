# Referral Service

Referral Service is a microservice focused on managing patient referrals in the healthcare interoperability platform. It coordinates patient referrals between facilities and departments, enabling seamless communication and data exchange for critical healthcare workflows.

## Overview

Referral Service provides a RESTful API for managing healthcare referrals:
- **Referrals**: Coordinate patient referrals between facilities and departments
- **Patients**: Unified patient identification and tracking for referral workflows
- **Health Facilities**: Manage hospitals, clinics, and healthcare facilities in the referral network
- **Interoperability**: Enable communication between healthcare systems for referral coordination

> **Note**: This service currently includes patient and facility management components. In future iterations, authentication and facility management will be extracted into separate microservices.

## Technology Stack

- **Java 21**: Programming language
- **Spring Boot 4.0.0**: Application framework
- **Spring Data JPA**: Data persistence
- **PostgreSQL**: Database
- **Lombok**: Reduce boilerplate code
- **OpenAPI/Swagger**: API documentation
- **Maven**: Build and dependency management

## Prerequisites

Before running Referral Service, ensure you have the following installed:

- Java 21 or higher
- PostgreSQL database
- Maven 3.6+ (or use included Maven wrapper)

## Database Setup

1. Create a PostgreSQL database (the default database name is `referral_service`):
```bash
createdb referral_service
```

2. Configure database credentials using environment variables:
```bash
export DB_URL=jdbc:postgresql://localhost:5432/referral_service
export DB_USERNAME=your_username
export DB_PASSWORD=your_password
```

3. The application will automatically use these environment variables. See `src/main/resources/application.properties` for the configuration structure.

## Installation & Running

1. Clone the repository:
```bash
git clone https://github.com/openbunch/CareBridge.git
cd CareBridge
```

> **Note**: The repository is named CareBridge for historical reasons. This service is now focused on referral management.

2. Build the project:
```bash
./mvnw clean install
```

3. Run the application with environment variables:
```bash
DB_URL=jdbc:postgresql://localhost:5432/referral_service \
DB_USERNAME=your_username \
DB_PASSWORD=your_password \
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`

## API Documentation

Once the application is running, you can access the interactive API documentation at:

- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **OpenAPI JSON**: http://localhost:8080/v3/api-docs

## API Authentication

Referral Service uses API key authentication via the `X-API-Key` header. To use the API:

1. Create a health facility to receive an API key:
```bash
POST /api/v1/facilities
```

2. Include the API key in subsequent requests:
```bash
X-API-Key: your-api-key-here
```

## Contributing

Contributions are welcome! Please feel free to submit issues and pull requests.

## License

This project is open source and available under the specified license terms.
