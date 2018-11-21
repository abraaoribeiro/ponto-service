package br.abraao.pa.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = { "id" })
@NoArgsConstructor
public class Funcionario {
	
	@Id
	private Long id;
	private String nome;
	private String email;
	private String matricula;
	private LocalDate dataNascimento;
	private LocalTime horarioEntrada;
	private LocalTime horarioSaida;
	

}
