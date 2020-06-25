package com.project.model.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.ValidationException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.project.entity.CursoEntity;
import com.project.repository.CursoRepository;
import com.project.service.CursoService;

public class CursoTests extends AbstractIntegrationTests {

	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private CursoService cursoService;
	
	/*
	 * ========================= CADASTRAR =========================
	 */
	
	@Test
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarCursoMustPass() {
		CursoEntity curso = new CursoEntity();
		curso.setNomeCurso("nomeCurso");
		curso.setInstituicao("instituicao");
		curso.setDataInicial(LocalDateTime.now());
		curso.setDataFinal(LocalDateTime.now());
		this.cursoService.cadastrarCurso(curso);
		Assert.assertNotNull(curso.getId());
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarCursoMustFailNomeCursoNotNull() {
		CursoEntity curso = new CursoEntity();
		curso.setNomeCurso(null);
		curso.setInstituicao("instituicao");
		curso.setDataInicial(LocalDateTime.now());
		curso.setDataFinal(LocalDateTime.now());
		this.cursoService.cadastrarCurso(curso);
		Assert.assertNotNull(curso.getId());
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarCursoMustFailInstituicaoNotNull() {
		CursoEntity curso = new CursoEntity();
		curso.setNomeCurso("nomeCurso");
		curso.setInstituicao(null);
		curso.setDataInicial(LocalDateTime.now());
		curso.setDataFinal(LocalDateTime.now());
		this.cursoService.cadastrarCurso(curso);
		Assert.assertNotNull(curso.getId());
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarCursoMustFailDataInicialNotNull() {
		CursoEntity curso = new CursoEntity();
		curso.setNomeCurso("nomeCurso");
		curso.setInstituicao("instituicao");
		curso.setDataInicial(null);
		curso.setDataFinal(LocalDateTime.now());
		this.cursoService.cadastrarCurso(curso);
		Assert.assertNotNull(curso.getId());
	}
	
	/*
	 * ========================= CONSULTAR =========================
	 */
	
	@Test
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void consultarCursoMustPass() {
		List<CursoEntity> cursos = this.cursoRepository.findAll();
		Assert.assertEquals(cursos.size(), 1);
	}
	
	/*
	 * ========================= ATUALIZAR =========================
	 */
	
	@Test
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void atualizarCursoMustPass() {
		CursoEntity curso = this.cursoRepository.findById(1000L).orElse(null);
		curso.setNomeCurso("nomeCurso");
		this.cursoService.atualizarCurso(curso);
		Assert.assertTrue(curso.getNomeCurso().equals("nomeCurso"));
	}	
}