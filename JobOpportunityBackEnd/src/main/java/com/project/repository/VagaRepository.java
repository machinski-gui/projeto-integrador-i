package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.VagaEntity;

public interface VagaRepository extends JpaRepository<VagaEntity, Long> {
	
}
