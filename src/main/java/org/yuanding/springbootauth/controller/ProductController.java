package org.yuanding.springbootauth.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.yuanding.springbootauth.controller.dto.createProductDto;
import org.yuanding.springbootauth.model.Product;
import org.yuanding.springbootauth.repository.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@PostMapping
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Product> createProduct(@RequestBody createProductDto productDto) {
		Product product = new Product();
		product.setName(productDto.getName());
		productRepository.save(product);
		return ResponseEntity.ok(product);
	}

	@GetMapping
	public ResponseEntity<List<Product>> getProducts() {
		return ResponseEntity.ok(productRepository.findAll());
	}

    @GetMapping("/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable Long id, HttpServletResponse response) {
		return productRepository.findById(id)
				.map(product -> ResponseEntity.ok().body(product))
				.orElse(ResponseEntity.notFound().build());
	}
}