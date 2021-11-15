package model;

import java.util.ArrayList;
import java.util.HashSet;


public class Aluno extends Pessoa{
		
	public Curso curso;
	
	public ArrayList<Disciplina> disciplinasRealizadas;//previous
	
	public ArrayList<Disciplina> disciplinasInscritas;//current
	
	public float TotalCargaHorariaCumprida;
	
	public Aluno() {
		TotalCargaHorariaCumprida = 0;		
	}
	
	
	public Aluno(String nome, HashSet<String> cpf) {
		super(nome, cpf);
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public ArrayList<Disciplina> getDisciplinaRealizadas() {
		return disciplinasRealizadas;
	}

	public void setDisciplinaRealizadas(ArrayList<Disciplina> disciplinaRealizadas) {
		this.disciplinasRealizadas = disciplinaRealizadas;
	}

	public ArrayList<Disciplina> getDisciplinasInscritas() {
		return disciplinasInscritas;
	}

	public void setDisciplinasInscritas(ArrayList<Disciplina> disciplinasInscritas) {
		this.disciplinasInscritas = disciplinasInscritas;
	}

	public float getTotalCargaHorariaCumprida() {
		return TotalCargaHorariaCumprida;
	}

	public void setTotalCargaHorariaCumprida(float TotalCargaHorariaCumprida) {
		this.TotalCargaHorariaCumprida = TotalCargaHorariaCumprida;
	}
	
	
}