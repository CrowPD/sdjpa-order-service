package com.practice.orders.domain;

import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderHeaderTest {

	@Test
	void testEquals() {
		var oh1 = new OrderHeader();
		oh1.setId(1L);
		var oh3 = new OrderHeader();
		oh3.setId(1L);

		assertEquals(oh1, oh1);
		assertEquals(oh1, oh3);
	}

	@Test
	void testNotEquals() {
		var oh1 = new OrderHeader();
		oh1.setId(1L);
		oh1.setCustomerName("Some");
		var oh2 = new OrderHeader();
		oh2.setId(2L);
		var oh3 = new OrderHeader();
		oh3.setId(1L);
		oh3.setCustomerName("Name");

		assertNotEquals(oh1, oh2);
		assertNotEquals(oh1, oh3);
	}
}