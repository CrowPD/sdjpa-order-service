package com.practice.orders.repo;

import com.practice.orders.domain.Product;
import com.practice.orders.domain.ProductStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryTest {
	@Autowired
	ProductRepository productRepository;

	@Test
	void testBasicRead() {
		List<Product> all = productRepository.findAll();

		assertNotNull(all);
		Assertions.assertFalse(all.isEmpty());
	}

	@Test
	void testDml() {
		var paper = new Product();
		paper.setDescription("Paper");
		var saved = productRepository.save(paper);
		assertNotNull(saved);

		assertNotNull(saved.getId());
		assertNotNull(saved.getCreatedDate());

		saved.setStatus(ProductStatus.DISCONTINUED);
		productRepository.save(saved);
		var updated = productRepository.findById(saved.getId()).get();

		assertEquals(saved.getId(), updated.getId());
		assertEquals(saved.getCreatedDate(), updated.getCreatedDate());
		assertEquals(saved.getStatus(), updated.getStatus());

		assertNotNull(updated.getLastModifiedDate());
	}
}