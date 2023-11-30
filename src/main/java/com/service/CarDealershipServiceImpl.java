package com.service;

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

	// Metodo senza mappa passando la lista di cars attravenrso la classe Dealership
	@Override
	public Map<Dealership, List<Car>> insertCarsDealership2(Dealership dealership) {
		Map<Dealership, List<Car>> result = new HashMap<>();

		String vatNumber = dealership.getVatNumber();
		List<Car> cars = dealership.getCars();

		dealership.setCars(null);
		dealRep.save(dealership);

		cars.forEach(c -> c.setDealership(dealership));

		// Salviamo le auto nel database
		cars = carRep.saveAll(cars);

		// Aggiorniamo l'associazione nelle auto
		dealership.setCars(cars);
//		dealRep.save(dealership);

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

}
