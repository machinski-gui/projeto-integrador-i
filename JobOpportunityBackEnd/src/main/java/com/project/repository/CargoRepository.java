package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.CargoEntity;

public interface CargoRepository extends JpaRepository<CargoEntity, Long> {
	
}
