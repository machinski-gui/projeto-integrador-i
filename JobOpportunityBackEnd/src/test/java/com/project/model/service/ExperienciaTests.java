package com.project.model.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.ValidationException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.project.entity.ExperienciaEntity;
import com.project.repository.ExperienciaRepository;
import com.project.service.ExperienciaService;

public class ExperienciaTests extends AbstractIntegrationTests {

	@Autowired
	private ExperienciaRepository experienciaRepository;
	
	@Autowired
	private ExperienciaService experienciaService;
	
	/*
	 * ========================= CADASTRAR =========================
	 */
	
	@Test
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarExperienciaMustPass() {
		ExperienciaEntity experiencia = new ExperienciaEntity();
		experiencia.setNomeEmpresa("nomeEmpresa");
		experiencia.setCargo("cargo");
		experiencia.setDataInicial(LocalDateTime.now());
		experiencia.setDataFinal(LocalDateTime.now());
		this.experienciaService.cadastrarExperiencia(experiencia);
		Assert.assertNotNull(experiencia.getId());
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarExperienciaMustFailNomeEmpresaNotNull() {
		ExperienciaEntity experiencia = new ExperienciaEntity();
		experiencia.setNomeEmpresa(null);
		experiencia.setCargo("cargo");
		experiencia.setDataInicial(LocalDateTime.now());
		experiencia.setDataFinal(LocalDateTime.now());
		this.experienciaService.cadastrarExperiencia(experiencia);
		Assert.assertNotNull(experiencia.getId());
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarExperienciaMustFailCargoNotNull() {
		ExperienciaEntity experiencia = new ExperienciaEntity();
		experiencia.setNomeEmpresa("nomeEmpresa");
		experiencia.setCargo(null);
		experiencia.setDataInicial(LocalDateTime.now());
		experiencia.setDataFinal(LocalDateTime.now());
		this.experienciaService.cadastrarExperiencia(experiencia);
		Assert.assertNotNull(experiencia.getId());
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarExperienciaMustFailDataInicialNotNull() {
		ExperienciaEntity experiencia = new ExperienciaEntity();
		experiencia.setNomeEmpresa("nomeEmpresa");
		experiencia.setCargo("cargo");
		experiencia.setDataInicial(null);
		experiencia.setDataFinal(LocalDateTime.now());
		this.experienciaService.cadastrarExperiencia(experiencia);
		Assert.assertNotNull(experiencia.getId());
	}
	
	/*
	 * ========================= CONSULTAR =========================
	 */
	
	@Test
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void consultarExperienciaMustPass() {
		List<ExperienciaEntity> experiencias = this.experienciaRepository.findAll();
		Assert.assertEquals(experiencias.size(), 1);
	}
	
	/*
	 * ========================= ATUALIZAR =========================
	 */
	
	@Test
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void atualizarExperienciaMustPass() {
		ExperienciaEntity experiencia = this.experienciaRepository.findById(1000L).orElse(null);
		experiencia.setNomeEmpresa("nomeEmpresa");
		this.experienciaService.atualizarExperiencia(experiencia);
		Assert.assertTrue(experiencia.getNomeEmpresa().equals("nomeEmpresa"));
	}
}