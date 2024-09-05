package com.practice.orders.domain;

import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
public class OrderHeader extends BaseEntity {
	private String customerName;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof OrderHeader that)) return false;
		if (!super.equals(o)) return false;

		return Objects.equals(customerName, that.customerName);
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + Objects.hashCode(customerName);
		return result;
	}
}
