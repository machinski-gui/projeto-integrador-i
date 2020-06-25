package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.CandidatoEntity;
import com.project.repository.CandidatoRepository;

@Service
@Transactional
public class CandidatoService {
	
	@Autowired
	private CandidatoRepository candidatoRepository;
	
	public CandidatoEntity cadastrarCandidato(CandidatoEntity candidato) {
		return this.candidatoRepository.save(candidato);
	}
	
	public List<CandidatoEntity> consultarCandidato() {
		return this.candidatoRepository.findAll();
	}
	
	public CandidatoEntity atualizarCandidato(CandidatoEntity candidato) {
		return this.candidatoRepository.save(candidato);
	}
}