package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.CandidatoVagaEntity;
import com.project.repository.CandidatoVagaRepository;

@Service
@Transactional
public class CandidatoVagaService {

	@Autowired
	private CandidatoVagaRepository candidatoVagaRepository;
	
	public CandidatoVagaEntity cadastrarCandidatoVaga(CandidatoVagaEntity candidatoVaga) {
		return this.candidatoVagaRepository.save(candidatoVaga);
	}
	
	public List<CandidatoVagaEntity> consultarCandidatoVaga() {
		return this.candidatoVagaRepository.findAll();
	}
	
	public CandidatoVagaEntity atualizarCandidatoVaga(CandidatoVagaEntity candidatoVaga) {
		return this.candidatoVagaRepository.save(candidatoVaga);
	}
}