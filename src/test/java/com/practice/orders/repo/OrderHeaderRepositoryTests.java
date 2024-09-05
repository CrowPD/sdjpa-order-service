package com.practice.orders.repo;

import com.practice.orders.domain.OrderHeader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OrderHeaderRepositoryTests {
	@Autowired
	OrderHeaderRepository orderHeaderRepository;

	@Test
	void testBasicRead() {
		List<OrderHeader> all = orderHeaderRepository.findAll();

		assertNotNull(all);
		Assertions.assertFalse(all.isEmpty());
	}

	@Test
	void testDml() {
		var header = new OrderHeader();
		header.setCustomerName("Mickey");
		var saved = orderHeaderRepository.save(header);
		assertNotNull(saved);

		assertNotNull(saved.getId());
		assertNotNull(saved.getCreatedDate());
	}
}
