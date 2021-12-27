package model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JTextField;


public class Curso {
	
	private HashSet<String> codigo;

	private  String nome;

	private ArrayList<Disciplina> disciplinas;
	
	private ArrayList<Horario> horarios;
	
	private ArrayList<Aluno> alunos;
	

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
	
	@SuppressWarnings("unused")
	public void editarCurso(ArrayList<Curso> cursos, SimpleDateFormat formatHorarioCurso, JTextField textFielCodigo, JTextField textFieldNovoHorario, JTextField textFieldHorario) {
		for(int i = 0; i < cursos.size(); i++) {
			
			if(cursos.get(i).getCodigo().contains(textFielCodigo.getText())) {
				
				for(int j = 0; j < cursos.get(i).getHorarios().size(); j++) {
					
					if(cursos.get(i).getHorarios().get(j).getHorario().contains(textFieldHorario.getText())) {
						
						try {			
							
							formatHorarioCurso.parse(textFieldNovoHorario.getText());
							cursos.get(i).getHorarios().get(j).setHorario(textFieldNovoHorario.getText());
							System.out.println(cursos.get(i).getHorarios().get(j).getHorario());
						} catch (ParseException e1) {

							e1.printStackTrace();
						}

					}

				}

			}

		}		
	}

	public void mudarNomeCurso(ArrayList<Curso> cursos, JTextField textFielCodigo, JTextField textFieldNovoNome) {
		for(int i = 0; i < cursos.size(); i++) {
			System.out.println("c");
			if(cursos.get(i).getCodigo().contains(textFielCodigo.getText())) {
				System.out.println("c");
				cursos.get(i).setNome(textFieldNovoNome.getText());
				System.out.println("Nome modificado " + cursos.get(i).getNome());

			}

		}
		
	}
	
}
