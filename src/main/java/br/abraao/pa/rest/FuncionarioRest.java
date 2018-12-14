package br.abraao.pa.rest;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.abraao.pa.domain.Funcionario;
import br.abraao.pa.repository.FuncionarioRepository;

@RestController
@RequestMapping("api/funcionarios")
public class FuncionarioRest {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@GetMapping
	public ResponseEntity<?> findAll(Pageable pageable) {
		return ResponseEntity.ok().cacheControl(CacheControl.maxAge(10, TimeUnit.SECONDS))
				.body(funcionarioRepository.findAll(pageable));
	}

	@GetMapping(path = "/{id}")
	public Optional<Funcionario> findOne(@PathVariable("id") Long id) {
		if (!funcionarioRepository.existsById(id)) {
			throw new EntityNotFoundException(String.format("Entidade Foo não encontrada. id=%d"));
		}
		return funcionarioRepository.findById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Funcionario insert(@RequestBody Funcionario foo) {
		return funcionarioRepository.save(foo);
		
	}

	@PutMapping(path = "/{id}")
	public Funcionario update(@PathVariable("id") Long id, @RequestBody Funcionario funcionario) {
		if (!funcionarioRepository.existsById(id)) {
			throw new EntityNotFoundException("Entidade Foo não encontrada");
		}
		return funcionarioRepository.save(funcionario);
	}

	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		if (!funcionarioRepository.existsById(id)) {
			throw new EntityNotFoundException("Entidade Foo não encontrada");
		}
		funcionarioRepository.deleteById(id);
	}

}
