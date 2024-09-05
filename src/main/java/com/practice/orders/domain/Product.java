package com.practice.orders.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.Objects;

@Entity
public class Product extends BaseEntity {
	private String description;
	@Enumerated(EnumType.STRING)
	private ProductStatus status;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProductStatus getStatus() {
		return status;
	}

	public void setStatus(ProductStatus productStatus) {
		this.status = productStatus;
	}

	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Product product)) return false;
		if (!super.equals(o)) return false;

		return Objects.equals(description, product.description) && status == product.status;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + Objects.hashCode(description);
		result = 31 * result + Objects.hashCode(status);
		return result;
	}
}
