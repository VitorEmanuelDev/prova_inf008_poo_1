package model;


import java.util.ArrayList;
import java.util.HashSet;


public class Disciplina {
	
	private HashSet<String> codigo;
	
	private String sigla;
	
	private String nome;
	
	private ArrayList<Aula> aulas;
	
	private ArrayList<Horario> horarios;
	
	private Docente docente;
	
	private ArrayList<String> datas;
	
	
	public Disciplina() {}
	
	
	

	public Disciplina(HashSet<String> codigo, String sigla, String nome, ArrayList<Aula> aulas,
			ArrayList<Horario> horarios, Docente docente, ArrayList<String> datas) {
		super();
		this.codigo = codigo;
		this.sigla = sigla;
		this.nome = nome;
		this.aulas = aulas;
		this.horarios = horarios;
		this.docente = docente;
		this.datas = datas;
	}




	public HashSet<String> getCodigo() {
		return codigo;
	}
	public void setCodigo(HashSet<String> codigo) {
		this.codigo = codigo;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Aula> getAula() {
		return aulas;
	}
	public void setAula(ArrayList<Aula> aulas) {
		this.aulas = aulas;
	}

	final public Docente getDocente() {
		return docente;
	}
	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public ArrayList<String> getDatas() {
		return datas;
	}

	public void setDatas(ArrayList<String> datas) {
		this.datas = datas;
	}

	public ArrayList<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(ArrayList<Horario> horarios) {
		this.horarios = horarios;
	}


}
