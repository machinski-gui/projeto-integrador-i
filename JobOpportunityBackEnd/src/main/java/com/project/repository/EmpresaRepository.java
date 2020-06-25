package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.EmpresaEntity;

public interface EmpresaRepository extends JpaRepository<EmpresaEntity, Long> {
	
}
