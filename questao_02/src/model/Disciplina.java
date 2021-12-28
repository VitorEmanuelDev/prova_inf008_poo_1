package model;


import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JTextField;


public class Disciplina {
	
	private HashSet<String> codigo;
	
	private String sigla;
	
	private String nome;
	
	private ArrayList<Aula> aulas;
	
	private ArrayList<Horario> horarios;
	
	private Docente docente;
	
	private ArrayList<String> datas;

	private float nota;
	
	public Disciplina() {}
	

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
	public ArrayList<Aula> getAulas() {
		return aulas;
	}
	public void setAulas(ArrayList<Aula> aulas) {
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

	public float getNota() {
		return nota;
	}


	public void setNota(float nota) {
		this.nota = nota;
	}


	public void alterarNomeDisciplina(ArrayList<Disciplina> disciplinas, JTextField textFieldNome, JTextField textFieldCodigo) {
		for(int i = 0; i < disciplinas.size(); i++) {

			if(disciplinas.get(i).getCodigo().contains(textFieldCodigo.getText())) {

				disciplinas.get(i).setNome(textFieldNome.getText());
				System.out.println("Nome da disciplina alterado " + disciplinas.get(i).getNome());

			}

		}		
	}


	public void alterarCargaHorariaDisciplina(ArrayList<Disciplina> disciplinas, JTextField textFieldCodigo,
			JTextField textFieldCargaHoraria) {
		for(int i = 0; i < disciplinas.size(); i++) {

			if(disciplinas.get(i).getCodigo().contains(textFieldCodigo.getText())) {

				for(int j = 0; j < disciplinas.get(i).getAulas().size(); j++) {

					int cargaHoraria = Integer.parseInt(textFieldCargaHoraria.getText());

					disciplinas.get(i).getAulas().get(j).setDuracao(cargaHoraria);
					System.out.println("Carga horária da disciplina alterada " + disciplinas.get(i).getNome());


				}
			}

		}
		
	}


	public void alterarHorarioDisciplina(ArrayList<Disciplina> disciplinas, JTextField textFieldCodigo,
			JTextField textFieldHorario, JTextField textFieldHorarioNovo) {
		
		for(int i = 0; i < disciplinas.size(); i++) {
			
			if(disciplinas.get(i).getCodigo().contains(textFieldCodigo.getText())) {

				for(int j = 0; j < disciplinas.get(i).getHorarios().size(); j++) {

					if(disciplinas.get(i).getHorarios().contains(textFieldHorario.getText())){

						disciplinas.get(i).getHorarios().get(j).setHorario(textFieldHorarioNovo.getText());
						System.out.println("Horário alterado " + disciplinas.get(i).getHorarios().get(j).getHorario());
					}

				}
			}

		}
	}


	public void alterarDataDisciplina(ArrayList<Disciplina> disciplinas, JTextField textFieldCodigo,
			JTextField textFieldDataAntiga, JTextField textFieldDataNova) {
		for(int i = 0; i < disciplinas.size(); i++) {

			if(disciplinas.get(i).getCodigo().contains(textFieldCodigo.getText())) {

				for(int j = 0; j < disciplinas.get(i).getDatas().size(); j++) {

					if(disciplinas.get(i).getDatas().contains(textFieldDataAntiga.getText())){

						disciplinas.get(i).getDatas().get(j).replace(textFieldDataAntiga.getText(), textFieldDataNova.getText());
						System.out.println("Data alterada " + disciplinas.get(i).getDatas().get(j));
					}

				}
			}

		}
		
	}


	public void adicionarNovoDocente(ArrayList<Disciplina> disciplinas, JTextField textFieldCodigo,
			JTextField textFieldCPFAtual, JTextField textFieldCPF, JTextField textFieldNome) {
		for(int i = 0; i < disciplinas.size(); i++) {

			if(disciplinas.get(i).getCodigo().contains(textFieldCodigo.getText())) {

				if(disciplinas.get(i).getDocente().getCpf().contains(textFieldCPFAtual.getText())){

					disciplinas.get(i).getDocente().getCpf().remove(textFieldCPFAtual.getText());
					disciplinas.get(i).getDocente().getCpf().add(textFieldCPF.getText());
					disciplinas.get(i).getDocente().setNome(textFieldNome.getText());
					System.out.println("Docente alterado " + disciplinas.get(i).getDocente().getNome());

				}
			}

		}		
	}


}
