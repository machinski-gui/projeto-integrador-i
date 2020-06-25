package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.VagaEntity;
import com.project.repository.VagaRepository;

@Service
@Transactional
public class VagaService {

	@Autowired
	private VagaRepository vagaRepository;
	
	public VagaEntity cadastrarVaga(VagaEntity vaga) {
		return this.vagaRepository.save(vaga);
	}
	
	public List<VagaEntity> consultarVaga() {
		return this.vagaRepository.findAll();
	}
	
	public VagaEntity atualizarVaga(VagaEntity vaga) {
		return this.vagaRepository.save(vaga);
	}	
}