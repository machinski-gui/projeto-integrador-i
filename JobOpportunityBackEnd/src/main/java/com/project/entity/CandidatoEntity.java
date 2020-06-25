package com.project.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
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
public class CandidatoEntity extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(length = 100)
	@NotNull
	private String nomeCompleto;
	
	@Column(length = 15, unique = true)
	@NotNull
	private String rg;
	
	@Column(length = 15, unique = true)
	@NotNull
	private String cpf;
	
	@Column(length = 15)
	@NotNull
	private String sexo;
	
	@NotNull
	private LocalDateTime dataNascimento;
	
	@NotNull
	private boolean isInativo;
	
	@NotNull
	@OneToOne
	private LoginEntity login;
	
	@NotNull
	@OneToOne
	private EnderecoEntity endereco;
}