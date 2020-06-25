package com.project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class EnderecoEntity extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(length = 9)
	@NotBlank
	private String cep;

	@Column(length = 100)
	@NotNull
	private String logradouro;
	
	@Column(length = 10)
	@NotNull
	private String numero;
	
	@Column(length = 100)
	@NotNull
	private String bairro;
	
	@Column(length = 100)
	@NotNull
	private String cidade;
	
	@Column(length = 100)
	@NotNull
	private String estado;
	
	@Column(length = 15)
	@NotBlank
	private String telefone;
	
	@Column(length = 15)
	@NotBlank
	private String celular;
	
	@Column(length = 50)
	@NotNull
	private String email;
}