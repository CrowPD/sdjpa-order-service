package com.practice.orders.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Objects;

@MappedSuperclass
public abstract class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@CreationTimestamp
	@Column(updatable = false)
	private Timestamp createdDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof BaseEntity that)) return false;

		return Objects.equals(id, that.id) && Objects.equals(createdDate, that.createdDate);
	}

	@Override
	public int hashCode() {
		int result = Objects.hashCode(id);
		result = 31 * result + Objects.hashCode(createdDate);
		return result;
	}
}
