package com.project.model.service;

import java.util.List;

import javax.validation.ValidationException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.project.entity.EmpresaEntity;
import com.project.entity.EnderecoEntity;
import com.project.entity.LoginEntity;
import com.project.repository.EmpresaRepository;
import com.project.repository.EnderecoRepository;
import com.project.repository.LoginRepository;
import com.project.service.EmpresaService;

public class EmpresaTests extends AbstractIntegrationTests {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private EmpresaService empresaService;
	
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
	public void cadastrarEmpresaMustPass() {
		EmpresaEntity empresa = new EmpresaEntity();
		LoginEntity login = this.loginRepository.findById(1000L).orElse(null);
		EnderecoEntity endereco = this.enderecoRepository.findById(1000L).orElse(null);
		empresa.setRazaoSocial("razaoSocial");
		empresa.setNomeFantasia("nomeFantasia");
		empresa.setCnpj("cnpj");
		empresa.setInativo(false);
		empresa.setLogin(login);
		empresa.setEndereco(endereco);
		this.empresaService.cadastrarEmpresa(empresa);
		Assert.assertNotNull(empresa.getId());		
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarEmpresaMustFailRazaoSocialNotNull() {
		EmpresaEntity empresa = new EmpresaEntity();
		LoginEntity login = this.loginRepository.findById(1000L).orElse(null);
		EnderecoEntity endereco = this.enderecoRepository.findById(1000L).orElse(null);
		empresa.setRazaoSocial(null);
		empresa.setNomeFantasia("nomeFantasia");
		empresa.setCnpj("cnpj");
		empresa.setInativo(false);
		empresa.setLogin(login);
		empresa.setEndereco(endereco);
		this.empresaService.cadastrarEmpresa(empresa);
		Assert.assertNotNull(empresa.getId());		
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarEmpresaMustFailNomeFantasiaNotNull() {
		EmpresaEntity empresa = new EmpresaEntity();
		LoginEntity login = this.loginRepository.findById(1000L).orElse(null);
		EnderecoEntity endereco = this.enderecoRepository.findById(1000L).orElse(null);
		empresa.setRazaoSocial("razaoSocial");
		empresa.setNomeFantasia(null);
		empresa.setCnpj("cnpj");
		empresa.setInativo(false);
		empresa.setLogin(login);
		empresa.setEndereco(endereco);
		this.empresaService.cadastrarEmpresa(empresa);
		Assert.assertNotNull(empresa.getId());		
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarEmpresaMustFailCnpjNotNull() {
		EmpresaEntity empresa = new EmpresaEntity();
		LoginEntity login = this.loginRepository.findById(1000L).orElse(null);
		EnderecoEntity endereco = this.enderecoRepository.findById(1000L).orElse(null);
		empresa.setRazaoSocial("razaoSocial");
		empresa.setNomeFantasia("nomeFantasia");
		empresa.setCnpj(null);
		empresa.setInativo(false);
		empresa.setLogin(login);
		empresa.setEndereco(endereco);
		this.empresaService.cadastrarEmpresa(empresa);
		Assert.assertNotNull(empresa.getId());		
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarEmpresaMustFailLoginNotNull() {
		EmpresaEntity empresa = new EmpresaEntity();
		EnderecoEntity endereco = this.enderecoRepository.findById(1000L).orElse(null);
		empresa.setRazaoSocial("razaoSocial");
		empresa.setNomeFantasia("nomeFantasia");
		empresa.setCnpj("cnpj");
		empresa.setInativo(false);
		empresa.setLogin(null);
		empresa.setEndereco(endereco);
		this.empresaService.cadastrarEmpresa(empresa);
		Assert.assertNotNull(empresa.getId());		
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarEmpresaMustFailEnderecoNotNull() {
		EmpresaEntity empresa = new EmpresaEntity();
		LoginEntity login = this.loginRepository.findById(1000L).orElse(null);
		empresa.setRazaoSocial("razaoSocial");
		empresa.setNomeFantasia("nomeFantasia");
		empresa.setCnpj("cnpj");
		empresa.setInativo(false);
		empresa.setLogin(login);
		empresa.setEndereco(null);
		this.empresaService.cadastrarEmpresa(empresa);
		Assert.assertNotNull(empresa.getId());		
	}
	
	/*
	 * ========================= CONSULTAR =========================
	 */
	
	@Test
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void consultarEmpresaMustPass() {
		List<EmpresaEntity> empresas = this.empresaRepository.findAll();
		Assert.assertEquals(empresas.size(), 1);
	}
	
	/*
	 * ========================= ATUALIZAR =========================
	 */
	
	@Test
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void atualizarEmpresaMustPass() {
		EmpresaEntity empresa = this.empresaRepository.findById(1000L).orElse(null);
		empresa.setRazaoSocial("razaoSocial");
		this.empresaService.atualizarEmpresa(empresa);
		Assert.assertTrue(empresa.getRazaoSocial().equals("razaoSocial"));
	}
}