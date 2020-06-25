package com.project.model.service;

import java.util.List;

import javax.validation.ValidationException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.project.entity.CargoEntity;
import com.project.entity.EmpresaEntity;
import com.project.entity.VagaEntity;
import com.project.repository.CargoRepository;
import com.project.repository.EmpresaRepository;
import com.project.repository.VagaRepository;
import com.project.service.VagaService;

public class VagaTests extends AbstractIntegrationTests {

	@Autowired
	private VagaRepository vagaRepository;
	
	@Autowired
	private VagaService vagaService;
	
	@Autowired
	private CargoRepository cargoRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	/*
	 * ========================= CADASTRAR =========================
	 */
	
	@Test
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarVagaMustPass() {
		VagaEntity vaga = new VagaEntity();
		CargoEntity cargo = this.cargoRepository.findById(1000L).orElse(null);
		EmpresaEntity empresa = this.empresaRepository.findById(1000L).orElse(null);
		vaga.setDescricao("descricao");
		vaga.setSalario(0D);
		vaga.setCargaHoraria("0");
		vaga.setFinalizado(false);
		vaga.setCargo(cargo);
		vaga.setEmpresa(empresa);
		this.vagaService.cadastrarVaga(vaga);
		Assert.assertNotNull(vaga.getId());		
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarVagaMustFailDescricaoNotNull() {
		VagaEntity vaga = new VagaEntity();
		CargoEntity cargo = this.cargoRepository.findById(1000L).orElse(null);
		EmpresaEntity empresa = this.empresaRepository.findById(1000L).orElse(null);
		vaga.setDescricao(null);
		vaga.setSalario(0D);
		vaga.setCargaHoraria("0");
		vaga.setFinalizado(false);
		vaga.setCargo(cargo);
		vaga.setEmpresa(empresa);
		this.vagaService.cadastrarVaga(vaga);
		Assert.assertNotNull(vaga.getId());		
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarVagaMustFailCargoNotNull() {
		VagaEntity vaga = new VagaEntity();
		EmpresaEntity empresa = this.empresaRepository.findById(1000L).orElse(null);
		vaga.setDescricao("descricao");
		vaga.setSalario(0D);
		vaga.setCargaHoraria("0");
		vaga.setFinalizado(false);
		vaga.setCargo(null);
		vaga.setEmpresa(empresa);
		this.vagaService.cadastrarVaga(vaga);
		Assert.assertNotNull(vaga.getId());		
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarVagaMustFailEmpresaNotNull() {
		VagaEntity vaga = new VagaEntity();
		CargoEntity cargo = this.cargoRepository.findById(1000L).orElse(null);
		vaga.setDescricao("descricao");
		vaga.setSalario(0D);
		vaga.setCargaHoraria("0");
		vaga.setFinalizado(false);
		vaga.setCargo(cargo);
		vaga.setEmpresa(null);
		this.vagaService.cadastrarVaga(vaga);
		Assert.assertNotNull(vaga.getId());		
	}
	
	/*
	 * ========================= CONSULTAR =========================
	 */
	
	@Test
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void consultarVagaMustPass() {
		List<VagaEntity> vagas = this.vagaRepository.findAll();
		Assert.assertEquals(vagas.size(), 1);
	}
	
	/*
	 * ========================= ATUALIZAR =========================
	 */
	
	@Test
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void atualizarVagaMustPass() {
		VagaEntity vaga = this.vagaRepository.findById(1000L).orElse(null);
		vaga.setDescricao("descricao");
		this.vagaService.atualizarVaga(vaga);
		Assert.assertTrue(vaga.getDescricao().equals("descricao"));
	}
}