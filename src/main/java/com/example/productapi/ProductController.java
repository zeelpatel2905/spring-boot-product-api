package com.example.productapi;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private static final Map<Long, Product> PRODUCTS = Map.of(
			1L, new Product(1L, "Notebook"),
			2L, new Product(2L, "Pen"));

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable long id) {
		Product p = PRODUCTS.get(id);
		if (p == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(p);
	}
}
