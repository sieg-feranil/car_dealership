package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class Car {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer carId;

	@Column(unique = true)
	@Pattern(regexp = "^[A-Z]{2}\\\\d{2,3}[A-Z]{1,2}$", message = "Formato non corretto!")
	private String plate;

	private String model;

	private Double price;

	@ManyToOne
	@JoinColumn(name = "dealershipId", nullable = false)
	private Dealership dealership;

	// Insert
	public Car(@Pattern(regexp = "^[A-Z]{2}\\\\d{2,3}[A-Z]{1,2}$", message = "Formato non corretto!") String plate,
			String model, Double price) {
		this.plate = plate;
		this.model = model;
		this.price = price;
	}

	// Update
	public Car(Integer carId,
			@Pattern(regexp = "^[A-Z]{2}\\\\d{2,3}[A-Z]{1,2}$", message = "Formato non corretto!") String plate,
			String model, Double price) {
		this.carId = carId;
		this.plate = plate;
		this.model = model;
		this.price = price;
	}

	// Delete
	public Car(Integer carId) {
		this.carId = carId;
	}

	@Override
	public String toString() {
		return "Car [carId=" + carId + ", plate=" + plate + ", model=" + model + ", price=" + price + "]";
	}

}
