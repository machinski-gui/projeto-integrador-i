package com.project.model.service;

import java.util.List;

import javax.validation.ValidationException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.project.entity.CandidatoEntity;
import com.project.entity.CandidatoVagaEntity;
import com.project.entity.VagaEntity;
import com.project.repository.CandidatoRepository;
import com.project.repository.CandidatoVagaRepository;
import com.project.repository.VagaRepository;
import com.project.service.CandidatoVagaService;

public class CandidatoVagaTests extends AbstractIntegrationTests {

	@Autowired
	private CandidatoVagaRepository candidatoVagaRepository;
	
	@Autowired
	private CandidatoVagaService candidatoVagaService;
	
	@Autowired
	private CandidatoRepository candidatoRepository;
	
	@Autowired
	private VagaRepository vagaRepository;
	
	/*
	 * ========================= CADASTRAR =========================
	 */
	
	@Test
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarCandidatoVagaMustPass() {
		CandidatoVagaEntity candidatoVaga = new CandidatoVagaEntity();
		CandidatoEntity candidato = this.candidatoRepository.findById(1000L).orElse(null);
		VagaEntity vaga = this.vagaRepository.findById(1000L).orElse(null);
		candidatoVaga.setCandidato(candidato);
		candidatoVaga.setVaga(vaga);
		this.candidatoVagaService.cadastrarCandidatoVaga(candidatoVaga);
		Assert.assertNotNull(candidatoVaga.getId());
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarCandidatoVagaMustFailCandidatoNotNull() {
		CandidatoVagaEntity candidatoVaga = new CandidatoVagaEntity();
		VagaEntity vaga = this.vagaRepository.findById(1000L).orElse(null);
		candidatoVaga.setCandidato(null);
		candidatoVaga.setVaga(vaga);
		this.candidatoVagaService.cadastrarCandidatoVaga(candidatoVaga);
		Assert.assertNotNull(candidatoVaga.getId());
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarCandidatoVagaMustFailVagaNotNull() {
		CandidatoVagaEntity candidatoVaga = new CandidatoVagaEntity();
		CandidatoEntity candidato = this.candidatoRepository.findById(1000L).orElse(null);
		candidatoVaga.setCandidato(candidato);
		candidatoVaga.setVaga(null);
		this.candidatoVagaService.cadastrarCandidatoVaga(candidatoVaga);
		Assert.assertNotNull(candidatoVaga.getId());
	}
	
	/*
	 * ========================= CONSULTAR =========================
	 */
	
	@Test
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void consultarCandidatoVagaMustPass() {
		List<CandidatoVagaEntity> candidatoVagas = this.candidatoVagaRepository.findAll();
		Assert.assertEquals(candidatoVagas.size(), 1);
	}
	
	/*
	 * ========================= ATUALIZAR =========================
	 */
	
	@Test
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void atualizarCandidatoVagaMustPass() {
		CandidatoVagaEntity candidatoVaga = this.candidatoVagaRepository.findById(1000L).orElse(null);
		CandidatoEntity candidato = this.candidatoRepository.findById(1000L).orElse(null);
		candidatoVaga.setCandidato(candidato);
		this.candidatoVagaService.atualizarCandidatoVaga(candidatoVaga);
		Assert.assertTrue(candidatoVaga.getCandidato().equals(candidato));
	}
}