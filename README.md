# Product API

A small Spring Boot REST API demonstrating reliable handling of product lookups and HTTP response codes.

## What I fixed

The `GET /api/products/{id}` endpoint previously returned `200 OK` even when the requested product did not exist, resulting in a successful response with an empty body. I updated the endpoint to return `404 Not Found` for unknown product IDs and to return the found product with `200 OK` otherwise.

I added regression tests covering both cases: retrieving an existing product and requesting a product that is not found.

## API

| Method | Endpoint | Behavior |
| --- | --- | --- |
| `GET` | `/api/products/1` | Returns the Notebook product with `200 OK` |
| `GET` | `/api/products/2` | Returns the Pen product with `200 OK` |
| `GET` | `/api/products/{unknownId}` | Returns `404 Not Found` |

## Run

```shell
./mvnw spring-boot:run
```

On Windows, use `mvnw.cmd spring-boot:run`.

Run the tests with `./mvnw test` (or `mvnw.cmd test` on Windows).

Example request:

```shell
curl http://localhost:8080/api/products/1
```
