package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.CursoEntity;

public interface CursoRepository extends JpaRepository<CursoEntity, Long> {
	
}
