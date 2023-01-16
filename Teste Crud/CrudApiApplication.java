package br.com.testebackend.crudapi;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.testebackend.crudapi.entities.Endereco;
import br.com.testebackend.crudapi.entities.Pessoa;
import br.com.testebackend.crudapi.repositories.EnderecoRepository;
import br.com.testebackend.crudapi.repositories.PessoaRepository;

@SpringBootApplication
public class CrudApiApplication implements CommandLineRunner{
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public static void main(String[] args) {
		SpringApplication.run(CrudApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Endereco end1 = new Endereco(null, "RUA 5", "04727-119", "77","São Paulo");
		Endereco end2 = new Endereco(null, "RUA 7", "04727-119", "99","Belo Horizonte");
		
		Pessoa p1 = new Pessoa(	null, "Maria", "18/01/1898", end1);
		Pessoa p2 = new Pessoa(null, "Maria Silva", "18/09/1989", end2);
		
		end1.getPessoas().addAll(Arrays.asList(p1));
		end2.getPessoas().addAll(Arrays.asList(p2));
		
		
		enderecoRepository.save(end1);
		enderecoRepository.save(end2);
		
		pessoaRepository.save(p1);
		pessoaRepository.save(p2);
			
	}
}