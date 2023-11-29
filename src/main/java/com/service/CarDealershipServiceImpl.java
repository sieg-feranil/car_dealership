package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Car;
import com.entity.Dealership;
import com.repository.CarRepository;
import com.repository.DealershipRepository;

@Service
public class CarDealershipServiceImpl implements CarDealershipService {

	@Autowired
	private DealershipRepository dealRep;

	@Autowired
	private CarRepository carRep;

	@Override
	public Map<Dealership, List<Car>> insertCarsDealership(Map<Dealership, List<Car>> carsDealership) {
		// Dealership dealership, List<Car> cars

		Map<Dealership, List<Car>> result = new HashMap<>();

		Dealership tempDealership = null;

		List<Car> cars = new ArrayList<>();

		for (Map.Entry<Dealership, List<Car>> entry : carsDealership.entrySet()) {
			tempDealership = entry.getKey();
			cars = entry.getValue();
		}

		String vatNumber = tempDealership.getVatNumber();

		// Controlliamo che non esista gia' il concessionario nel DB
		if (dealRep.existsById(vatNumber)) {
			System.out.println("Esiste gia!");
			return null;
		}

		Dealership dealership = dealRep.save(tempDealership);

		// Ad ogni car della lista associamo il dealership
		cars.forEach(c -> {
			c.setDealership(dealership);
		});

		Iterable<Car> carsIt = cars;

		cars = carRep.saveAll(carsIt);

		result.put(dealership, cars);

		return result;
	}

	// Metodo senza mappa passando la lista di cars attravenrso la classe Dealership
	@Override
	public Map<Dealership, List<Car>> insertCarsDealership2(Dealership dealership) {
		Map<Dealership, List<Car>> result = new HashMap<>();

		String vatNumber = dealership.getVatNumber();

		List<Car> cars = dealership.getCars();

//		// Controlliamo che non esista gia' il concessionario nel DB
//		if (dealRep.existsById(vatNumber)) {
//			System.out.println("Esiste gia!");
//			return null;
//		}

		System.out.println("Prima: " + dealership);
		dealRep.save(dealership);

		// Ad ogni car della lista associamo il dealership
		cars.forEach(c -> {
			c.setDealership(dealership);
		});

		Iterable<Car> carsIt = cars;

		cars = carRep.saveAll(carsIt);

		result.put(dealership, cars);

		return result;
	}

	@Override
	public Map<Dealership, List<Car>> updateCarsOfDealership(String vatNumber, List<Car> cars) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Boolean, String> deleteDealership(Dealership dealership) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Dealership, List<Car>> findAllCarDealrships() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Dealership, List<Car>> findCarDealrshipByVatNumber(Dealership dealership) {
		// TODO Auto-generated method stub
		return null;
	}

	private Integer getIdByVatNumber(String vatNumber) {

		return null;
	}

}
