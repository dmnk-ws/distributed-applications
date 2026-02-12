# Distributed Applications 25/26

An educational e-commerce platform demonstrating distributed, multi-tenant microservices architecture. Built incrementally across 14 weekly exercises covering Spring Boot, REST APIs, microservice communication, and modern frontend development.

## Architecture

The system consists of three components:

```
┌──────────────┐       ┌──────────────────┐       ┌──────────────────┐
│  Frontend    │──────▶│  Main Backend    │──────▶│ Second Backend   │
│  (Svelte)    │       │  (Spring Boot)   │       │ (Spring Boot)    │
│  Vite dev    │       │  Port 8080       │       │ Port 8081        │
└──────────────┘       └──────────────────┘       └──────────────────┘
                       │ Multi-tenant     │       │ External product │
                       │ Product catalog  │       │ data source      │
                       │ Orders & cart    │       └──────────────────┘
                       │ Reviews (WS)     │
                       │ User management  │
                       └──────────────────┘
```

- **main-backend** — Primary Spring Boot application with multi-tenant product catalog, shopping cart, orders, reviews (via WebSocket), and user management. Aggregates data from the second backend through a facade layer.
- **second-backend** — Lightweight Spring Boot microservice providing external product data over REST.
- **frontend** — Svelte SPA that consumes the main backend API with tenant-aware requests.

## Tech Stack

| Layer    | Technology                              |
|----------|-----------------------------------------|
| Backend  | Java 21, Spring Boot 3.5 / 4.0, Maven   |
| Database | H2 (file-based), MySQL (optional)       |
| API Docs | SpringDoc OpenAPI (Swagger UI)          |
| Frontend | Svelte 5, Vite 7, JavaScript            |
| Realtime | Spring WebSocket                        |

## Getting Started

### Prerequisites

- Java 21+
- Maven 3+
- Node.js 18+

### Run the backends

```bash
# Terminal 1 — Main backend (port 8080)
cd main-backend
./mvnw spring-boot:run

# Terminal 2 — Second backend (port 8081)
cd second-backend
./mvnw spring-boot:run
```

### Run the frontend

```bash
cd frontend
npm install
npm run dev
```

### Explore the API

- Swagger UI: http://localhost:8080/swagger-ui.html
- H2 Console: http://localhost:8080/h2

## Key Concepts

### Multi-Tenancy

Tenants are identified via HTTP headers (`X-TENANT-ID`, `X-API-KEY`). Each tenant is mapped to a product category so they see only their own slice of the catalog. Allowed tenants and their mappings are configured in `application.properties`.

### Microservice Communication

The main backend fetches external products from the second backend via `RestTemplate` and merges them with internal products through the `SaaSCatalogFacade`.

### Security

Two servlet filters protect the `/saas` endpoints:
- **ApiKeyFilter** — validates the `X-API-KEY` header
- **TenantFilter** — validates the `X-TENANT-ID` header against an allow-list

## Project Structure

```
├── main-backend/          Spring Boot primary backend
│   └── src/main/java/com/example/dist_app/
│       ├── products/      Product CRUD, catalog facade
│       ├── order/         Order processing
│       ├── cart/          Shopping cart
│       ├── user/          User management
│       ├── review/        Reviews (WebSocket)
│       ├── security/      API key & tenant filters
│       ├── config/        Tenant & REST configuration
│       └── service/       Email, inventory, pricing
├── second-backend/        Spring Boot product microservice
├── frontend/              Svelte SPA
├── exercises/             Weekly exercise sheets (0–13)
└── QUESTIONS.md           Theory answers & reflections
```

## Exercises

The `exercises/` directory contains 14 PDF sheets (0–13) that guided the incremental development of this system, covering:

- Spring Boot fundamentals & dependency injection
- REST API design & CRUD operations
- Service layer architecture & facade pattern
- Multi-tenant systems & security filters
- Microservice communication & data aggregation
- WebSocket real-time features
- Cloud-native design principles