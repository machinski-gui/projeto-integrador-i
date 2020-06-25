package com.project.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class CursoEntity extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(length = 100)
	@NotNull
	private String nomeCurso;
	
	@Column(length = 100)
	@NotNull
	private String instituicao;

	@NotNull
	private LocalDateTime dataInicial;

	private LocalDateTime dataFinal;	
}