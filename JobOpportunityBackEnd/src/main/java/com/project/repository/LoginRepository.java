package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.LoginEntity;

public interface LoginRepository extends JpaRepository<LoginEntity, Long> {
	
}
