package com.project.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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
public class CurriculoEntity extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@NotNull
	private CandidatoEntity candidato;
	
	@ManyToOne
	private CursoEntity curso;
	
	@ManyToOne
	private ExperienciaEntity experiencia;
	
	@ManyToOne
	private FormacaoEntity formacao;		
}