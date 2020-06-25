package com.project.model.service;

import java.util.List;

import javax.validation.ValidationException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.project.entity.CandidatoEntity;
import com.project.entity.CurriculoEntity;
import com.project.entity.CursoEntity;
import com.project.entity.ExperienciaEntity;
import com.project.entity.FormacaoEntity;
import com.project.repository.CandidatoRepository;
import com.project.repository.CurriculoRepository;
import com.project.repository.CursoRepository;
import com.project.repository.ExperienciaRepository;
import com.project.repository.FormacaoRepository;
import com.project.service.CurriculoService;

public class CurriculoTests extends AbstractIntegrationTests {

	@Autowired
	private CurriculoRepository curriculoRepository;
	
	@Autowired
	private CurriculoService curriculoService;
	
	@Autowired
	private CandidatoRepository candidatoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private ExperienciaRepository experienciaRepository;
	
	@Autowired
	private FormacaoRepository formacaoRepository;
	
	/*
	 * ========================= CADASTRAR =========================
	 */
	
	@Test
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarCurriculoMustPass() {
		CurriculoEntity curriculo = new CurriculoEntity();
		CandidatoEntity candidato = this.candidatoRepository.findById(1000L).orElse(null);
		CursoEntity curso = this.cursoRepository.findById(1000L).orElse(null);
		ExperienciaEntity experiencia = this.experienciaRepository.findById(1000L).orElse(null);
		FormacaoEntity formacao = this.formacaoRepository.findById(1000L).orElse(null);
		curriculo.setCandidato(candidato);
		curriculo.setCurso(curso);
		curriculo.setExperiencia(experiencia);
		curriculo.setFormacao(formacao);
		this.curriculoService.cadastrarCurriculo(curriculo);
		Assert.assertNotNull(curriculo.getId());
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarCurriculoMustFailCandidatoNotNull() {
		CurriculoEntity curriculo = new CurriculoEntity();
		CursoEntity curso = this.cursoRepository.findById(1000L).orElse(null);
		ExperienciaEntity experiencia = this.experienciaRepository.findById(1000L).orElse(null);
		FormacaoEntity formacao = this.formacaoRepository.findById(1000L).orElse(null);
		curriculo.setCandidato(null);
		curriculo.setCurso(curso);
		curriculo.setExperiencia(experiencia);
		curriculo.setFormacao(formacao);
		this.curriculoService.cadastrarCurriculo(curriculo);
		Assert.assertNotNull(curriculo.getId());
	}
	
	/*
	 * ========================= CONSULTAR =========================
	 */
	
	@Test
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void consultarCurriculoMustPass() {
		List<CurriculoEntity> curriculos = this.curriculoRepository.findAll();
		Assert.assertEquals(curriculos.size(), 1);
	}
	
	/*
	 * ========================= ATUALIZAR =========================
	 */
	
	@Test
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void atualizarCurriculoMustPass() {
		CurriculoEntity curriculo = this.curriculoRepository.findById(1000L).orElse(null);
		CandidatoEntity candidato = this.candidatoRepository.findById(1000L).orElse(null);
		curriculo.setCandidato(candidato);
		this.curriculoService.atualizarCurriculo(curriculo);
		Assert.assertTrue(curriculo.getCandidato().equals(candidato));
	}
}