package com.project.model.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.ValidationException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.project.entity.CandidatoEntity;
import com.project.entity.EnderecoEntity;
import com.project.entity.LoginEntity;
import com.project.repository.CandidatoRepository;
import com.project.repository.EnderecoRepository;
import com.project.repository.LoginRepository;
import com.project.service.CandidatoService;

public class CandidatoTests extends AbstractIntegrationTests {

	@Autowired
	private CandidatoRepository candidatoRepository;
	
	@Autowired
	private CandidatoService candidatoService;
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	/*
	 * ========================= CADASTRAR =========================
	 */
	
	@Test
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarCandidatoMustPass() {
		CandidatoEntity candidato = new CandidatoEntity();
		LoginEntity login = this.loginRepository.findById(1000L).orElse(null);
		EnderecoEntity endereco = this.enderecoRepository.findById(1000L).orElse(null);
		candidato.setNomeCompleto("nomeCompleto");
		candidato.setRg("rg");
		candidato.setCpf("cpf");
		candidato.setSexo("sexo");
		candidato.setDataNascimento(LocalDateTime.now());
		candidato.setInativo(false);
		candidato.setLogin(login);
		candidato.setEndereco(endereco);
		this.candidatoService.cadastrarCandidato(candidato);
		Assert.assertNotNull(candidato.getId());
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarCandidatoMustFailNomeCompletoNotNull() {
		CandidatoEntity candidato = new CandidatoEntity();
		LoginEntity login = this.loginRepository.findById(1000L).orElse(null);
		EnderecoEntity endereco = this.enderecoRepository.findById(1000L).orElse(null);
		candidato.setNomeCompleto(null);
		candidato.setRg("rg");
		candidato.setCpf("cpf");
		candidato.setSexo("sexo");
		candidato.setDataNascimento(LocalDateTime.now());
		candidato.setInativo(false);
		candidato.setLogin(login);
		candidato.setEndereco(endereco);
		this.candidatoService.cadastrarCandidato(candidato);
		Assert.assertNotNull(candidato.getId());
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarCandidatoMustFailRgNotNull() {
		CandidatoEntity candidato = new CandidatoEntity();
		LoginEntity login = this.loginRepository.findById(1000L).orElse(null);
		EnderecoEntity endereco = this.enderecoRepository.findById(1000L).orElse(null);
		candidato.setNomeCompleto("nomeCompleto");
		candidato.setRg(null);
		candidato.setCpf("cpf");
		candidato.setSexo("sexo");
		candidato.setDataNascimento(LocalDateTime.now());
		candidato.setInativo(false);
		candidato.setLogin(login);
		candidato.setEndereco(endereco);
		this.candidatoService.cadastrarCandidato(candidato);
		Assert.assertNotNull(candidato.getId());
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarCandidatoMustFailCpfNotNull() {
		CandidatoEntity candidato = new CandidatoEntity();
		LoginEntity login = this.loginRepository.findById(1000L).orElse(null);
		EnderecoEntity endereco = this.enderecoRepository.findById(1000L).orElse(null);
		candidato.setNomeCompleto("nomeCompleto");
		candidato.setRg("rg");
		candidato.setCpf(null);
		candidato.setSexo("sexo");
		candidato.setDataNascimento(LocalDateTime.now());
		candidato.setInativo(false);
		candidato.setLogin(login);
		candidato.setEndereco(endereco);
		this.candidatoService.cadastrarCandidato(candidato);
		Assert.assertNotNull(candidato.getId());
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarCandidatoMustFailSexoNotNull() {
		CandidatoEntity candidato = new CandidatoEntity();
		LoginEntity login = this.loginRepository.findById(1000L).orElse(null);
		EnderecoEntity endereco = this.enderecoRepository.findById(1000L).orElse(null);
		candidato.setNomeCompleto("nomeCompleto");
		candidato.setRg("rg");
		candidato.setCpf("cpf");
		candidato.setSexo(null);
		candidato.setDataNascimento(LocalDateTime.now());
		candidato.setInativo(false);
		candidato.setLogin(login);
		candidato.setEndereco(endereco);
		this.candidatoService.cadastrarCandidato(candidato);
		Assert.assertNotNull(candidato.getId());
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarCandidatoMustFailDataNascimentoNotNull() {
		CandidatoEntity candidato = new CandidatoEntity();
		LoginEntity login = this.loginRepository.findById(1000L).orElse(null);
		EnderecoEntity endereco = this.enderecoRepository.findById(1000L).orElse(null);
		candidato.setNomeCompleto("nomeCompleto");
		candidato.setRg("rg");
		candidato.setCpf("cpf");
		candidato.setSexo("sexo");
		candidato.setDataNascimento(null);
		candidato.setInativo(false);
		candidato.setLogin(login);
		candidato.setEndereco(endereco);
		this.candidatoService.cadastrarCandidato(candidato);
		Assert.assertNotNull(candidato.getId());
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarCandidatoMustFailLoginNotNull() {
		CandidatoEntity candidato = new CandidatoEntity();
		EnderecoEntity endereco = this.enderecoRepository.findById(1000L).orElse(null);
		candidato.setNomeCompleto("nomeCompleto");
		candidato.setRg("rg");
		candidato.setCpf("cpf");
		candidato.setSexo("sexo");
		candidato.setDataNascimento(LocalDateTime.now());
		candidato.setInativo(false);
		candidato.setLogin(null);
		candidato.setEndereco(endereco);
		this.candidatoService.cadastrarCandidato(candidato);
		Assert.assertNotNull(candidato.getId());
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarCandidatoMustFailEnderecoNotNull() {
		CandidatoEntity candidato = new CandidatoEntity();
		LoginEntity login = this.loginRepository.findById(1000L).orElse(null);
		candidato.setNomeCompleto("nomeCompleto");
		candidato.setRg("rg");
		candidato.setCpf("cpf");
		candidato.setSexo("sexo");
		candidato.setDataNascimento(LocalDateTime.now());
		candidato.setInativo(false);
		candidato.setLogin(login);
		candidato.setEndereco(null);
		this.candidatoService.cadastrarCandidato(candidato);
		Assert.assertNotNull(candidato.getId());
	}
	
	/*
	 * ========================= CONSULTAR =========================
	 */
	
	@Test
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void consultarCandidatoMustPass() {
		List<CandidatoEntity> candidato = this.candidatoRepository.findAll();
		Assert.assertEquals(candidato.size(), 1);
	}
	
	/*
	 * ========================= ATUALIZAR =========================
	 */
	
	@Test
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void atualizarCandidatoMustPass() {
		CandidatoEntity candidato = this.candidatoRepository.findById(1000L).orElse(null);
		candidato.setNomeCompleto("nomeCompleto");
		this.candidatoService.atualizarCandidato(candidato);
		Assert.assertTrue(candidato.getNomeCompleto().equals("nomeCompleto"));
	}
}