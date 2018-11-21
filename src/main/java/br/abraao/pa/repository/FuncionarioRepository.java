package br.abraao.pa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.abraao.pa.domain.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {


}
