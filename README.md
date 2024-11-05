# Pricing API

This project is a Maven multi-module Spring Boot application that provides a RESTful API for managing pricing information. It follows Hexagonal Architecture practices to ensure a clean separation of concerns and maintainability.

## Prerequisites

- Java 21
- Maven
- Docker (optional)

## Getting Started

1. Clone the repository (if you did not get the source code via zip file):
    ```
    git clone https://github.com/waltercrdz/pricing-api.git
    ```
2. Navigate into the project directory:
    ```
    cd pricing-api
    ```
3. Build the project:
    ```
    mvn clean package
    ```
4. Run the application
    ```
    java -jar pricing-infrastructure/target/pricing-infrastructure-0.0.1-SNAPSHOT.jar
    ```
5. Alternatively, you can run the application using Docker:
    ```
    docker-compose up --build app
    ```
6. The application will be accessible at `http://localhost:8080/api/princing/`

## Project Structure

The project follows a Hexagonal Architecture, also known as Ports and Adapters.

## Submodules

This project contains the following submodules:

### pricing-application

This submodule is dedicated to the application layer of the microservice. It contains the Application Service classes that orchestrate the business logic and interactions between other modules.

### pricing-domain

This submodule contains domain models of the microservice.

### pricing-infrastructure

This submodule contains the infrastructure layer of the microservice. It contains the REST controllers, repositories, and other classes that interact with external systems.

## API Endpoints

The following endpoints are available:

### Get Price

This endpoint retrieves the price information for a product on a specific date and brand.

```bash
curl -X GET "http://localhost:8080/api/princing/products/35455/prices?date=2020-06-14T10:00:00Z&brand_id=1" -H "accept: application/json"
```

#### Parameters

- `product_id` (required): The ID of the product.
- `date` (Optional): The date to retrieve the price information. The format is `yyyy-MM-dd'T'HH:mm:ss'Z'`. Defaults to the current date.
- `brand_id` (required): The ID of the brand.

#### Response

```json
{
  "product_id": 35455,
  "brand_id": 1,
  "price_list": 1,
  "start_date": "2020-06-14T00:00:00Z",
  "end_date": "2020-12-31T23:59:59Z",
  "price": 35.5,
  "currency": "EUR"
}
```

### Important Notes

The project uses the ISO 8601 date format for all date fields. The format is `yyyy-MM-dd'T'HH:mm:ss'Z'`.

## H2 Database Initialization

The project uses an H2 in-memory database. The database is initialized with some sample data when the application starts. The database console is available at `http://localhost:8080/api/princing/h2-console`. The JDBC URL is `jdbc:h2:mem:pricingdb`.

## OpenAPI

The project uses Springdoc OpenAPI to generate the API documentation. The documentation is available at `http://localhost:8080/api/princing/swagger-ui/index.html`.

## Contributing

This is a personal project template. Contributions are not currently being accepted.

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.