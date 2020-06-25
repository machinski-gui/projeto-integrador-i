package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.CandidatoEntity;

public interface CandidatoRepository extends JpaRepository<CandidatoEntity, Long> {
	
}
