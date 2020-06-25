package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.CurriculoEntity;
import com.project.repository.CurriculoRepository;

@Service
@Transactional
public class CurriculoService {

	@Autowired
	private CurriculoRepository curriculoRepository;
	
	public CurriculoEntity cadastrarCurriculo(CurriculoEntity curriculo) {
		return this.curriculoRepository.save(curriculo);
	}
	
	public List<CurriculoEntity> consultarCurriculo() {
		return this.curriculoRepository.findAll();
	}
	
	public CurriculoEntity atualizarCurriculo(CurriculoEntity curriculo) {
		return this.curriculoRepository.save(curriculo);
	}
}