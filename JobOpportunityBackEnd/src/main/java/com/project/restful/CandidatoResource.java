package com.project.restful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.CandidatoEntity;
import com.project.repository.CandidatoRepository;
import com.project.service.CandidatoService;

@Component
@RestController
@RequestMapping("/api/candidato")
public class CandidatoResource {

	@Autowired
	private CandidatoRepository candidatoRepository;
	
	@Autowired
	private CandidatoService candidatoService;
	
	@GetMapping("/consult")
	public List<CandidatoEntity> consultar() {
		return this.candidatoRepository.findAll();
	}
}
