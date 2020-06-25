package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.ExperienciaEntity;
import com.project.repository.ExperienciaRepository;

@Service
@Transactional
public class ExperienciaService {

	@Autowired
	private ExperienciaRepository experienciaRepository;
	
	public ExperienciaEntity cadastrarExperiencia(ExperienciaEntity experiencia) {
		return this.experienciaRepository.save(experiencia);
	}
	
	public List<ExperienciaEntity> consultarExperiencia() {
		return this.experienciaRepository.findAll();
	}
	
	public ExperienciaEntity atualizarExperiencia(ExperienciaEntity experiencia) {
		return this.experienciaRepository.save(experiencia);
	}
}