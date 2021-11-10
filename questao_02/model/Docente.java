package model;

import java.util.HashSet;

public class Docente extends Pessoa{
	
	public Docente() {}

	public Docente(String nome, HashSet<String> cpf) {
		super(nome, cpf);
	}

}
