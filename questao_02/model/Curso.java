package model;


import java.util.ArrayList;
import java.util.HashSet;


public class Curso {
	
	public HashSet<String> codigo;

	public  String nome;

	public ArrayList<Disciplina> disciplinas;
	
	public ArrayList<Horario> horarios;
	
	public ArrayList<Aluno> alunos;
	

	public Curso() {}
	
	


	public Curso(HashSet<String> codigo, String nome, ArrayList<Disciplina> disciplinas, ArrayList<Horario> horarios,
			ArrayList<Aluno> alunos) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.disciplinas = disciplinas;
		this.horarios = horarios;
		this.alunos = alunos;
	}





	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome != null)
			this.nome = nome;
	}

	public ArrayList<Disciplina> getDisciplina() {
		return disciplinas;
	}

	public void setDisciplina(ArrayList<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public ArrayList<Aluno> getAluno() {
		return alunos;
	}

	public void setAluno(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}


	public ArrayList<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(ArrayList<Horario> horarios) {
		this.horarios = horarios;
	}


	public HashSet<String> getCodigo() {
		return codigo;
	}


	public void setCodigo(HashSet<String> codigo) {
		this.codigo = codigo;
	}
	
	
	
}