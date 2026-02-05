# Theory reflection


## Exercise 0 - Introduction & Organisation

> **1)** What is the purpose / benefit of the **Spring** framework?

- Most popular Java framework
- Many problems solved
- Webserver embedded
- Lots of extensions
- Fast way to build web applications
- Dependency injection container with a couple of convenience layers
    - MVC architecture
    - Database access
    - Proxies

> **2)** What are annotations? Which ones did you use today?

**Metadata** that provides information or instructions to the compiler or framework about how to handle a piece of code, eliminating the need for boilerplate configuration files.

- `@RestController`
- `@GetMapping`

> **3)** What imports from the Spring frameworks did you use?

```java
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
```

> **4)** What is included in the pom.xml file?

**pom.xml** is a configuration file used by Maven to manage the build process, dependencies and metadata of a Java project.

> **5)** What annotations from the springframework did you use? What is the „magic“ behind them?

- `@RestController`: It is a flag that indicates to Spring MVC that the class is ready to handle web requests.
- `@GetMapping`: It maps incoming HTTP GET requests to the URL path of the controller method that is to be invoked.

> **6)** What happens if some attributes of the product model class are private and have no public getter method?

If an attribute is private and has no public getter method, it will **NOT** be included in the JSON response.

When Spring (specifically Jackson, the JSON serialization library) converts your Product objects to JSON, it uses reflection to discover which properties to serialize. By default, Jackson looks for:

1. Public getter methods (e.g., getPrice())
2. Public fields (rarely used in practice)

If an attribute is private and lacks a public getter, Jackson cannot access it through reflection and will simply ignore it during serialization.


## Exercise 2 - Client-Server Pattern & CRUD

> **1)** @PostMapping with @RequestParam (HTML form only) 
> 
> How would the complete request URL look like?

`http://localhost:8080/products/create?name=Lightsaber&price=999.99&size=1&color=blue`

> **2)** @PostMapping with @RequestBody (JSON + fetch API)
> 
> What could be the HTTP response codes for success and each of the possible failures?

- **201 Created**: Product successfully created
- **409 Conflict**: Duplicate product
- **400 Bad Request**: Missing or invalid parameters
- **500 Internal Server Error**: Unexpected error

> **3)** @DeleteMapping
> 
> What could be the HTTP response codes for success and each of the possible failures?

- **200 OK**: Product successfully deleted
- **404 Not Found**: Product ID doesn’t exist
- **400 Bad Request**: Invalid ID format
- **500 Internal Server Error**: Unexpected error

> **4)** @PutMapping
>
> What could be the HTTP response codes for success and each of the possible failures?

- **200 OK**: Product successfully updated
- **404 Not Found**: Product ID doesn’t exist
- **400 Bad Request**: Invalid request body or missing fields
- **500 Internal Server Error**: Unexpected error

> **5)** @PutMapping
> 
> What could go wrong - what exception handling do we need?

| # | Problem                              | Example                                                       | What to do                                           |
|---|--------------------------------------|---------------------------------------------------------------|------------------------------------------------------|
| 1 | **Product ID not found**             | Client sends `{id: 99, name: "X"}` but no such product exists | Throw `NotFoundException` and return `404 NOT FOUND` |
| 2 | **Invalid / missing fields in JSON** | Client sends `{price: "abc"}` or omits `id`                   | Return `400 BAD REQUEST`                             |
| 3 | **Empty or null request body**       | `PUT /update` with no body                                    | Return `400 BAD REQUEST`                             |
| 4 | **Duplicate product logic issues**   | Two products share same ID or name when they shouldn’t        | Return `409 CONFLICT`                                |
| 5 | **Type conversion errors**           | `price` as string, `id` as text                               | Return `400 BAD REQUEST`                             |
| 6 | **NullPointerException**             | Service or product list is null                               | Ensure service is properly injected; add null checks |
| 7 | **Unexpected exceptions**            | Any unhandled runtime errors                                  | Return `500 INTERNAL SERVER ERROR`                   |


## Exercise 6 - Components, Services, Component Models

> **1)** What happens if I add the docu to a private field instead of the public getter method?

Javadoc on private fields is **not included** in the generated documentation by default. The `javadoc` tool only generates documentation for public and protected members. Since private fields are implementation details not accessible to external code, they are excluded from the public API documentation.

However, documenting private fields can still be useful for:
- Internal documentation for developers working on the class
- IDE tooltips when hovering over the field within the same class
- Using the `-private` flag with the javadoc tool to include them

> **2)** What part of our code is not included in the JavaDoc?

The following parts are **not included** in the generated Javadoc:
- **Private members** (fields, methods, constructors) - unless `-private` flag is used
- **Package-private (default) members** - unless `-package` flag is used
- **Method body/implementation code** - only signatures and documentation are included
- **Local variables** inside methods
- **Comments that are not Javadoc format** (e.g., `//` or `/* */` instead of `/** */`)

> **3)** From which java package do we import the `BigDecimal` type?

`import java.math.*`


## Exercise 9 - Middleware, Architecture Patterns for Distributed Systems

> **1)** What happens if I autowire the UserService in the OrderService and the OrderService in the UserService?

Spring will fully construct each bean before it can be injected, when constructor injection is used:

1. Spring tries to create OrderService
2. OrderService needs IUserService → Spring tries to create UserService
3. UserService needs IOrderService → Spring tries to create OrderService
4. But OrderService is already being created → Spring raises an exception!


## Exercise 13 - Service Engineering, Service composition, Microservices, Security

> **1)** **Service design** - What could be a problem why an interface could not be easily designed using REST?

- Operations are not simple CRUD/GET operations but require complex multi-step processes
- The service needs to maintain state in an interaction session (REST is stateless)
- Example: Operations like Compare, CheckDelivery, MakeVirtualOrder require sequences of operations and state management, which suggests a SOAP-based approach rather than REST

> **2)** Why is a CRUD application a good candidate for a RESTful service design?

- Entity-oriented services map naturally to resources in REST
- CRUD operations (Create, Read, Update, Delete) map directly to HTTP verbs (POST, GET, PUT, DELETE)
- REST APIs are lightweight and use standard HTTP protocols
- Simple resource-based operations fit the RESTful architectural style perfectly

> **3)** In a RESTful application, you cannot persist state on the server. How could you solve this problem if consecutive requests are needed to achieve a complex operation?

- Create additional resources to represent the intermediate state
- Example: CheckDelivery and MakeVirtualOrder operations require an additional resource representing a "virtual order"
- Use POST to create this resource with the required data
- Use GET to retrieve the calculated results from this resource
- Pass information between services through these created resources

> **4)** **Service composition** - What is an advantage of designing workflows outside code?

- Business logic is abstracted/externalized from code (rule engines like Camunda)
- Workflows can be changed without modifying the source code
- Graphical notations (BPMN, UML activity diagrams) are more readable than code
- WS-BPEL can be generated automatically from graphical workflow designs
- Non-technical stakeholders can understand and modify business processes
- Clear separation between business logic and implementation

> **5)** List the 6 cloud native architecture requirements mentioned in class.

1. **Automated** - independent build & deployment
2. **Flexible reuse** - image containers can be deployed to any cluster
3. **Resilient & scalable** - service replica, health checks
4. **Dynamic** - orchestration via Kubernetes, rolling updates with zero downtime
5. **Observable** - monitoring
6. **Distributed** - each microservice is independent, copies per region possible

> **6)** How do I identify which part of my application could be implemented as an own microservice?

- Use Domain Driven Design (DDD) to structure the application by domains
- Identify independent business domains/functionalities
- Each domain with its own bounded context can become a microservice
- Examples: Customer, Contract, Pricing, Risk, Location, Submission Lifecycle
- Rule of thumb: 1 service per domain, 1 team per service
- Look for parts that can be developed, deployed, and scaled independently

> **7)** Name a problem that is caused by enforcing independent automated deployments for a large number of microservices (developed by different teams)

- Vulnerabilities need to be fixed in multiple places (more than once)
- Unclear responsibility for errors, updates, monitoring, and debugging
- Autonomy vs agreements conflicts - teams need to coordinate on releases, versioning, backwards compatibility
- Inconsistencies in API & data models, naming conventions between different backends and frontend
- Regression issues when external services are modified by other teams
- Difficult to maintain consistent testing strategies across teams