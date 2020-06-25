package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.CursoEntity;
import com.project.repository.CursoRepository;

@Service
@Transactional
public class CursoService {

	@Autowired
	private CursoRepository cursoRepository;
	
	public CursoEntity cadastrarCurso(CursoEntity curso) {
		return this.cursoRepository.save(curso);
	}
	
	public List<CursoEntity> consultarCurso() {
		return this.cursoRepository.findAll();
	}
	
	public CursoEntity atualizarCurso(CursoEntity curso) {
		return this.cursoRepository.save(curso);
	}
}