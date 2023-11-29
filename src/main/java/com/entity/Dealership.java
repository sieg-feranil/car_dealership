package com.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Dealership {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer dealershipId;

	@Pattern(regexp = "^[A-Z]{2}\\d{9}$", message = "Formato non corretto!")
	@Column(name = "vat_number", unique = true)
	private String vatNumber;

	private String name;

	private String country;

	private String city;

	@OneToMany(mappedBy = "dealership")
	List<Car> cars = new ArrayList<>();

	//
	public Dealership(@Pattern(regexp = "^[A-Z]{2}\\d{9}$", message = "Formato non corretto!") String vatNumber,
			String name, String country, String city) {
		this.vatNumber = vatNumber;
		this.name = name;
		this.country = country;
		this.city = city;
	}

	// Update
	public Dealership(Integer dealershipId,
			@Pattern(regexp = "^[A-Z]{2}\\d{9}$", message = "Formato non corretto!") String vatNumber, String name,
			String country, String city) {
		this.dealershipId = dealershipId;
		this.vatNumber = vatNumber;
		this.name = name;
		this.country = country;
		this.city = city;
	}

	// Delete
	public Dealership(@Pattern(regexp = "^[A-Z]{2}\\d{9}$", message = "Formato non corretto!") String vatNumber) {
		this.vatNumber = vatNumber;
	}

	@Override
	public String toString() {
		return "Dealership [dealershipId=" + dealershipId + ", vatNumber=" + vatNumber + ", name=" + name + ", country="
				+ country + ", city=" + city + "]";
	}

}
