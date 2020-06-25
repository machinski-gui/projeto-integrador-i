package com.project.model.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.ValidationException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.project.entity.FormacaoEntity;
import com.project.repository.FormacaoRepository;
import com.project.service.FormacaoService;

public class FormacaoTests extends AbstractIntegrationTests {

	@Autowired
	private FormacaoRepository formacaoRepository;
	
	@Autowired
	private FormacaoService formacaoService;
	
	/*
	 * ========================= CADASTRAR =========================
	 */
	
	@Test
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarFormacaoMustPass() {
		FormacaoEntity formacao = new FormacaoEntity();
		formacao.setNomeCurso("nomeCurso");
		formacao.setInstituicao("instituicao");
		formacao.setDataInicial(LocalDateTime.now());
		formacao.setDataFinal(LocalDateTime.now());
		this.formacaoService.cadastrarFormacao(formacao);
		Assert.assertNotNull(formacao.getId());
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarFormacaoMustFailNomeCursoNotNull() {
		FormacaoEntity formacao = new FormacaoEntity();
		formacao.setNomeCurso(null);
		formacao.setInstituicao("instituicao");
		formacao.setDataInicial(LocalDateTime.now());
		formacao.setDataFinal(LocalDateTime.now());
		this.formacaoService.cadastrarFormacao(formacao);
		Assert.assertNotNull(formacao.getId());
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarFormacaoMustFailInstituicaoNotNull() {
		FormacaoEntity formacao = new FormacaoEntity();
		formacao.setNomeCurso("nomeCurso");
		formacao.setInstituicao(null);
		formacao.setDataInicial(LocalDateTime.now());
		formacao.setDataFinal(LocalDateTime.now());
		this.formacaoService.cadastrarFormacao(formacao);
		Assert.assertNotNull(formacao.getId());
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarFormacaoMustFailDataInicialNotNull() {
		FormacaoEntity formacao = new FormacaoEntity();
		formacao.setNomeCurso("nomeCurso");
		formacao.setInstituicao("instituicao");
		formacao.setDataInicial(null);
		formacao.setDataFinal(LocalDateTime.now());
		this.formacaoService.cadastrarFormacao(formacao);
		Assert.assertNotNull(formacao.getId());
	}
	
	/*
	 * ========================= CONSULTAR =========================
	 */
	
	@Test
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void consultarFormacaoMustPass() {
		List<FormacaoEntity> formacoes = this.formacaoRepository.findAll();
		Assert.assertEquals(formacoes.size(), 1);
		
	}
	
	/*
	 * ========================= ATUALIZAR =========================
	 */
	
	@Test
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void atualizarFormacaoMustPass() {
		FormacaoEntity formacao = this.formacaoRepository.findById(1000L).orElse(null);
		formacao.setNomeCurso("nomeCurso");
		this.formacaoService.atualizarFormacao(formacao);
		Assert.assertTrue(formacao.getNomeCurso().equals("nomeCurso"));
	}
}