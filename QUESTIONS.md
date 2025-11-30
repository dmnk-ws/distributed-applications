# Theory reflection

---

> **T1)** What is the purpose / benefit of the **Spring** framework?

- Most popular Java framework
- Many problems solved
- Webserver embedded
- Lots of extensions
- Fast way to build web applications
- Dependency injection container with a couple of convenience layers
    - MVC architecture
    - Database access
    - Proxies

> **T2)** What are annotations? Which ones did you use today?

**Metadata** that provides information or instructions to the compiler or framework about how to handle a piece of code, eliminating the need for boilerplate configuration files.

- `@RestController`
- `@GetMapping`

> **T3)** What imports from the Spring frameworks did you use?

```java
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
```

> **T4)** What is included in the pom.xml file?

**pom.xml** is a configuration file used by Maven to manage the build process, dependencies and metadata of a Java project.

> **T5)** What happens if I add the docu to a private field instead of the public getter method?

Javadoc on private fields is **not included** in the generated documentation by default. The `javadoc` tool only generates documentation for public and protected members. Since private fields are implementation details not accessible to external code, they are excluded from the public API documentation.

However, documenting private fields can still be useful for:
- Internal documentation for developers working on the class
- IDE tooltips when hovering over the field within the same class
- Using the `-private` flag with the javadoc tool to include them

> **T6)** What part of our code is not included in the JavaDoc?

The following parts are **not included** in the generated Javadoc:
- **Private members** (fields, methods, constructors) - unless `-private` flag is used
- **Package-private (default) members** - unless `-package` flag is used
- **Method body/implementation code** - only signatures and documentation are included
- **Local variables** inside methods
- **Comments that are not Javadoc format** (e.g., `//` or `/* */` instead of `/** */`)

# Other questions

---

> **1)** What annotations from the springframework did you use? What is the „magic“ behind them?

- `@RestController`: It is a flag that indicates to Spring MVC that the class is ready to handle web requests.
- `@GetMapping`: It maps incoming HTTP GET requests to the URL path of the controller method that is to be invoked.

---

> **2)** What happens if some attributes of the product model class are private and have no public getter method?

If an attribute is private and has no public getter method, it will **NOT** be included in the JSON response.

When Spring (specifically Jackson, the JSON serialization library) converts your Product objects to JSON, it uses reflection to discover which properties to serialize. By default, Jackson looks for:

1. Public getter methods (e.g., getPrice())
2. Public fields (rarely used in practice)

If an attribute is private and lacks a public getter, Jackson cannot access it through reflection and will simply ignore it during serialization.

> **3)** @PostMapping with @RequestParam (HTML form only) 
> 
> How would the complete request URL look like?

`http://localhost:8080/products/create?name=Lightsaber&price=999.99&size=1&color=blue`

> **4)** @PostMapping with @RequestBody (JSON + fetch API)
> 
> What could be the HTTP response codes for success and each of the possible failures?

- **201 Created**: Product successfully created
- **409 Conflict**: Duplicate product
- **400 Bad Request**: Missing or invalid parameters
- **500 Internal Server Error**: Unexpected error

> **5)** @DeleteMapping
> 
> What could be the HTTP response codes for success and each of the possible failures?

- **200 OK**: Product successfully deleted
- **404 Not Found**: Product ID doesn’t exist
- **400 Bad Request**: Invalid ID format
- **500 Internal Server Error**: Unexpected error

> **6)** @PutMapping
>
> What could be the HTTP response codes for success and each of the possible failures?

- **200 OK**: Product successfully updated
- **404 Not Found**: Product ID doesn’t exist
- **400 Bad Request**: Invalid request body or missing fields
- **500 Internal Server Error**: Unexpected error

> **7)** @PutMapping
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

> **8)** From which java package do we import the `BigDecimal` type?

`import java.math.*`


