package model;

import java.util.HashSet;

public class Pessoa {
	
	private String nome;

	private HashSet<String> cpf;
	
	public Pessoa() {}

	public Pessoa(String nome, HashSet<String> cpf) {
		
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public HashSet<String> getCpf() {
		return cpf;
	}

	public void setCpf(HashSet<String> cpf) {
		this.cpf = cpf;
	}
	
}
