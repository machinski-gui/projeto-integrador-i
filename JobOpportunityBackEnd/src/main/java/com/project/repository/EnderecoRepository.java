package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.EnderecoEntity;

public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Long> {
	
}
