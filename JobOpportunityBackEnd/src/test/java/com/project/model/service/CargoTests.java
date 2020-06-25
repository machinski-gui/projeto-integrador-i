package com.project.model.service;

import java.util.List;

import javax.validation.ValidationException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.project.entity.CargoEntity;
import com.project.repository.CargoRepository;
import com.project.service.CargoService;

public class CargoTests extends AbstractIntegrationTests {

	@Autowired
	private CargoRepository cargoRepository;
	
	@Autowired
	private CargoService cargoService;
	
	/*
	 * ========================= CADASTRAR =========================
	 */
	
	@Test
	@Sql({"/dataset/truncate.sql",
		"/dataset/insert.sql"})
	public void cadastrarCargoMustPass() {
		CargoEntity cargo = new CargoEntity();
		cargo.setNome("nome");
		cargo.setDescricao("descricao");
		this.cargoService.cadastrarCargo(cargo);
		Assert.assertNotNull(cargo.getId());
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarCargoMustFailNomeNotNull() {
		CargoEntity cargo = new CargoEntity();
		cargo.setNome(null);
		cargo.setDescricao("descricao");
		this.cargoService.cadastrarCargo(cargo);
		Assert.assertNotNull(cargo.getId());
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarCargoMustFailDescricaoNotNull() {
		CargoEntity cargo = new CargoEntity();
		cargo.setNome("nome");
		cargo.setDescricao(null);
		this.cargoService.cadastrarCargo(cargo);
		Assert.assertNotNull(cargo.getId());
	}
	
	/*
	 * ========================= CONSULTAR =========================
	 */

	@Test
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void consultarCargoMustPass() {
		List<CargoEntity> cargos = this.cargoRepository.findAll();
		Assert.assertEquals(cargos.size(), 1);
	}
	
	/*
	 * ========================= ATUALIZAR =========================
	 */
	
	@Test
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void atualizarCargoMustPass() {
		CargoEntity cargo = this.cargoRepository.findById(1000L).orElse(null);
		cargo.setNome("nome");
		this.cargoService.atualizarCargo(cargo);
		Assert.assertTrue(cargo.getNome().equals("nome"));
	}
}