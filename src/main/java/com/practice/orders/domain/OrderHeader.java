package com.practice.orders.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@AttributeOverrides({
		@AttributeOverride(
				name = "shippingAddress.address",
				column = @Column(name = "shipping_address")
		),
		@AttributeOverride(
				name = "shippingAddress.city",
				column = @Column(name = "shipping_city")
		),
		@AttributeOverride(
				name = "shippingAddress.state",
				column = @Column(name = "shipping_state")
		),
		@AttributeOverride(
				name = "shippingAddress.zipCode",
				column = @Column(name = "shipping_zip_code")
		),
		@AttributeOverride(
				name = "billToAddress.address",
				column = @Column(name = "bill_to_address")
		),
		@AttributeOverride(
				name = "billToAddress.city",
				column = @Column(name = "bill_to_city")
		),
		@AttributeOverride(
				name = "billToAddress.state",
				column = @Column(name = "bill_to_state")
		),
		@AttributeOverride(
				name = "billToAddress.zipCode",
				column = @Column(name = "bill_to_zip_code")
		),
})
public class OrderHeader extends BaseEntity {
	private String customerName;
	@Embedded
	private Address shippingAddress;
	@Embedded
	private Address billToAddress;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Address getBillToAddress() {
		return billToAddress;
	}

	public void setBillToAddress(Address billToAddress) {
		this.billToAddress = billToAddress;
	}

	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof OrderHeader that)) return false;
		if (!super.equals(o)) return false;

		return Objects.equals(customerName, that.customerName) && Objects.equals(shippingAddress, that.shippingAddress) && Objects.equals(billToAddress, that.billToAddress);
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + Objects.hashCode(customerName);
		result = 31 * result + Objects.hashCode(shippingAddress);
		result = 31 * result + Objects.hashCode(billToAddress);
		return result;
	}
}
