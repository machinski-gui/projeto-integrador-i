package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.CargoEntity;
import com.project.repository.CargoRepository;

@Service
@Transactional
public class CargoService {

	@Autowired
	private CargoRepository cargoRepository;
	
	public CargoEntity cadastrarCargo(CargoEntity cargo) {
		return this.cargoRepository.save(cargo);
	}
	
	public List<CargoEntity> consultarCargo() {
		return this.cargoRepository.findAll();
	}
	
	public CargoEntity atualizarCargo(CargoEntity cargo) {
		return this.cargoRepository.save(cargo);
	}
}