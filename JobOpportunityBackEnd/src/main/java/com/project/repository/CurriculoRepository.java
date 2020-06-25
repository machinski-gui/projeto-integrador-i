package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.CurriculoEntity;

public interface CurriculoRepository extends JpaRepository<CurriculoEntity, Long> {
	
}
