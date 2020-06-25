package com.project.model.service;

import java.util.List;

import javax.validation.ValidationException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.project.entity.EnderecoEntity;
import com.project.repository.EnderecoRepository;
import com.project.service.EnderecoService;

public class EnderecoTests extends AbstractIntegrationTests {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private EnderecoService enderecoService;
	
	/*
	 * ========================= CADASTRAR =========================
	 */
	
	@Test
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarEnderecoMustPass() {
		EnderecoEntity endereco = new EnderecoEntity();
		endereco.setCep("cep");
		endereco.setLogradouro("logradouro");
		endereco.setNumero("numero");
		endereco.setBairro("bairro");
		endereco.setCidade("cidade");
		endereco.setEstado("estado");
		endereco.setTelefone("telefone");
		endereco.setCelular("celular");
		endereco.setEmail("email");
		this.enderecoService.cadastrarEndereco(endereco);
		Assert.assertNotNull(endereco.getId());
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarEnderecoMustFailCepNotBlank() {
		EnderecoEntity endereco = new EnderecoEntity();
		endereco.setCep("");
		endereco.setLogradouro("logradouro");
		endereco.setNumero("numero");
		endereco.setBairro("bairro");
		endereco.setCidade("cidade");
		endereco.setEstado("estado");
		endereco.setTelefone("telefone");
		endereco.setCelular("celular");
		endereco.setEmail("email");
		this.enderecoService.cadastrarEndereco(endereco);
		Assert.assertNotNull(endereco.getId());
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarEnderecoMustFailLogradouroNotNull() {
		EnderecoEntity endereco = new EnderecoEntity();
		endereco.setCep("cep");
		endereco.setLogradouro(null);
		endereco.setNumero("numero");
		endereco.setBairro("bairro");
		endereco.setCidade("cidade");
		endereco.setEstado("estado");
		endereco.setTelefone("telefone");
		endereco.setCelular("celular");
		endereco.setEmail("email");
		this.enderecoService.cadastrarEndereco(endereco);
		Assert.assertNotNull(endereco.getId());
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarEnderecoMustFailNumeroNotNull() {
		EnderecoEntity endereco = new EnderecoEntity();
		endereco.setCep("cep");
		endereco.setLogradouro("logradouro");
		endereco.setNumero(null);
		endereco.setBairro("bairro");
		endereco.setCidade("cidade");
		endereco.setEstado("estado");
		endereco.setTelefone("telefone");
		endereco.setCelular("celular");
		endereco.setEmail("email");
		this.enderecoService.cadastrarEndereco(endereco);
		Assert.assertNotNull(endereco.getId());
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarEnderecoMustFailBairroNotNull() {
		EnderecoEntity endereco = new EnderecoEntity();
		endereco.setCep("cep");
		endereco.setLogradouro("logradouro");
		endereco.setNumero("numero");
		endereco.setBairro(null);
		endereco.setCidade("cidade");
		endereco.setEstado("estado");
		endereco.setTelefone("telefone");
		endereco.setCelular("celular");
		endereco.setEmail("email");
		this.enderecoService.cadastrarEndereco(endereco);
		Assert.assertNotNull(endereco.getId());
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarEnderecoMustFailCidadeNotNull() {
		EnderecoEntity endereco = new EnderecoEntity();
		endereco.setCep("cep");
		endereco.setLogradouro("logradouro");
		endereco.setNumero("numero");
		endereco.setBairro("bairro");
		endereco.setCidade(null);
		endereco.setEstado("estado");
		endereco.setTelefone("telefone");
		endereco.setCelular("celular");
		endereco.setEmail("email");
		this.enderecoService.cadastrarEndereco(endereco);
		Assert.assertNotNull(endereco.getId());
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarEnderecoMustFailEstadoNotNull() {
		EnderecoEntity endereco = new EnderecoEntity();
		endereco.setCep("cep");
		endereco.setLogradouro("logradouro");
		endereco.setNumero("numero");
		endereco.setBairro("bairro");
		endereco.setCidade("cidade");
		endereco.setEstado(null);
		endereco.setTelefone("telefone");
		endereco.setCelular("celular");
		endereco.setEmail("email");
		this.enderecoService.cadastrarEndereco(endereco);
		Assert.assertNotNull(endereco.getId());
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarEnderecoMustFailTelefoneNotBlank() {
		EnderecoEntity endereco = new EnderecoEntity();
		endereco.setCep("cep");
		endereco.setLogradouro("logradouro");
		endereco.setNumero("numero");
		endereco.setBairro("bairro");
		endereco.setCidade("cidade");
		endereco.setEstado("estado");
		endereco.setTelefone("");
		endereco.setCelular("celular");
		endereco.setEmail("email");
		this.enderecoService.cadastrarEndereco(endereco);
		Assert.assertNotNull(endereco.getId());
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarEnderecoMustFailCelularNotBlank() {
		EnderecoEntity endereco = new EnderecoEntity();
		endereco.setCep("cep");
		endereco.setLogradouro("logradouro");
		endereco.setNumero("numero");
		endereco.setBairro("bairro");
		endereco.setCidade("cidade");
		endereco.setEstado("estado");
		endereco.setTelefone("telefone");
		endereco.setCelular("");
		endereco.setEmail("email");
		this.enderecoService.cadastrarEndereco(endereco);
		Assert.assertNotNull(endereco.getId());
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarEnderecoMustFailEmailNotNull() {
		EnderecoEntity endereco = new EnderecoEntity();
		endereco.setCep("cep");
		endereco.setLogradouro("logradouro");
		endereco.setNumero("numero");
		endereco.setBairro("bairro");
		endereco.setCidade("cidade");
		endereco.setEstado("estado");
		endereco.setTelefone("telefone");
		endereco.setCelular("celular");
		endereco.setEmail(null);
		this.enderecoService.cadastrarEndereco(endereco);
		Assert.assertNotNull(endereco.getId());
	}
	
	/*
	 * ========================= CONSULTAR =========================
	 */
	
	@Test
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void consultarEnderecoMustPass() {
		List<EnderecoEntity> enderecos = this.enderecoRepository.findAll();
		Assert.assertEquals(enderecos.size(), 1);
	}
	
	/*
	 * ========================= ATUALIZAR =========================
	 */
	
	@Test
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void atualizarEnderecoMustPass() {
		EnderecoEntity endereco = this.enderecoRepository.findById(1000L).orElse(null);
		endereco.setCep("cep");
		this.enderecoService.atualizarEndereco(endereco);
		Assert.assertTrue(endereco.getCep().equals("cep"));
	}
}