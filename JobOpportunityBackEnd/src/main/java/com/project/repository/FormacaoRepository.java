package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.FormacaoEntity;

public interface FormacaoRepository extends JpaRepository<FormacaoEntity, Long> {
	
}
