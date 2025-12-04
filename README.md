# CareBridge

CareBridge is an interoperability platform that bridges siloed healthcare systems such as Electronic Medical Records (EMR), laboratory information systems, pharmacy systems, and other healthcare applications. It enables seamless communication and data exchange between these disparate systems for critical workflows including patient referrals, drug dosage orders, lab results sharing, and coordinated care across multiple health facilities.

## Overview

CareBridge provides a RESTful API that acts as an integration layer for healthcare systems:
- **Health Facilities**: Register and manage hospitals, clinics, labs, and pharmacies in the network
- **Patients**: Unified patient identification and tracking across multiple systems
- **Referrals**: Coordinate patient referrals between facilities and departments
- **Interoperability**: Enable communication between EMR systems, labs, pharmacy systems, and other healthcare applications
- **Data Exchange**: Facilitate sharing of drug dosage orders, lab results, and clinical information

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

2. Configure database credentials using environment variables:
```bash
export DB_URL=jdbc:postgresql://localhost:5432/carbridge
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

2. Build the project:
```bash
./mvnw clean install
```

3. Run the application with environment variables:
```bash
DB_URL=jdbc:postgresql://localhost:5432/carbridge \
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

CareBridge uses API key authentication via the `X-API-Key` header. To use the API:

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
