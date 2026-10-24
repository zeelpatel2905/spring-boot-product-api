package com.example.productapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ProductApiApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void returnsProductWhenItExists() {
		ResponseEntity<Product> response = new ProductController().getProduct(1L);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
		assertEquals("Notebook", response.getBody().name());
	}

	@Test
	void returnsNotFoundWhenProductDoesNotExist() {
		ResponseEntity<Product> response = new ProductController().getProduct(999L);

		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}

}
