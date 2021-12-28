package model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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


	public void mostrarDisciplinas(ArrayList<Curso> cursos, JTextField textCursoCodigo) {
		
		HashMap<String, ArrayList<Disciplina>> alunoDisciplinasInscritasOuACursar = new HashMap<String, ArrayList<Disciplina>>();

		HashMap<String, ArrayList<Disciplina>> alunoDisciplinasRealizadas = new HashMap<String, ArrayList<Disciplina>>();


		for(int i = 0; i < cursos.size(); i++) {

			if(cursos.get(i).getCodigo().contains(textCursoCodigo.getText())) {

				for(int j = 0; j < cursos.get(i).getAluno().size(); j++) {

					for(int k = 0; k < cursos.get(i).getDisciplina().size(); k++) {

						for(int l = 0; l < cursos.get(i).getDisciplina().size(); l++) {

							for(int m = 0; m < cursos.get(i).getAluno().size(); m++) {
								
								for(int n = 0; n < cursos.get(i).getAluno().size(); n++) {

									if(cursos.get(i).getAluno().get(m).
									getDisciplinaRealizadas().get(n).
									getSigla().equals(cursos.get(i).
									getDisciplina().get(l).getSigla())) {
										
										alunoDisciplinasRealizadas.put(cursos.get(i).getAluno().get(m).getNome(), cursos.get(i).getDisciplina());
										
									}else {
										
										alunoDisciplinasInscritasOuACursar.put(cursos.get(i).getAluno().get(m).getNome(), cursos.get(i).getDisciplina());
										
									}
																																
								}
							}
						}
					}

				}
			}

		}

		JFrame frame = new JFrame();

		// Frame Title
		frame.setTitle("Disciplinas a cursar");


		JTable table = new JTable(alunoDisciplinasInscritasOuACursar.size(),2);
		int linha = 0;
		for(Entry<String, ArrayList<Disciplina>> entry: alunoDisciplinasInscritasOuACursar.entrySet()){
			table.setValueAt(entry.getKey(),linha,0);
			for(int i  = 0; i < entry.getValue().size(); i++) {
				table.setValueAt(entry.getValue().get(i).getNome(),linha,1);
			}
			linha++;
		}

		frame.setBounds(30, 40, 200, 300);

		// adding it to JScrollPane
		JScrollPane scrollPanel = new JScrollPane(table);
		frame.add(scrollPanel);
		// Frame Size
		frame.setSize(500, 200);
		// Frame Visible = true
		frame.setVisible(true);

		JFrame frame1 = new JFrame();

		// Frame Title
		frame1.setTitle("Disciplinas cursadas");

		JTable table1 = new JTable(alunoDisciplinasRealizadas.size(),2);

		int linha1 = 0;
		for(Entry<String, ArrayList<Disciplina>> entry: alunoDisciplinasRealizadas.entrySet()){
			table1.setValueAt(entry.getKey(),linha1,0);
			for(int i  = 0; i < entry.getValue().size(); i++) {
				table1.setValueAt(entry.getValue().get(i).getNome(),linha1,1);
			}
			linha1++;
		}

		frame1.setBounds(30, 40, 200, 300);

		// adding it to JScrollPane
		JScrollPane scrollPanel1 = new JScrollPane(table1);
		frame1.add(scrollPanel1);
		// Frame Size
		frame1.setSize(500, 200);
		// Frame Visible = true
		frame1.setVisible(true);
		
	}


	public void mostrarExALunos(ArrayList<Curso> cursos, ArrayList<Aluno> alunos, JTextField textFieldCodigo) {

		HashMap<String, String> alunosTela = new HashMap<String,String>();

		float duracaoCurso = 0;
		for(int i = 0; i < cursos.size(); i++) {
			if(cursos.get(i).getCodigo().contains(textFieldCodigo.getText())){
				for(int j = 0; j < cursos.get(i).getDisciplina().size(); j++) {
					for(int k = 0; k < cursos.get(i).getDisciplina().get(j).getAulas().size(); k++) {
						duracaoCurso += cursos.get(i).getDisciplina().get(j).getAulas().get(k).getDuracao();
					}
				}

			}
		}

		System.out.println("duracao "  + duracaoCurso );

		float cargaHorariaRealizada = 0;
		for(int i = 0; i < cursos.size(); i++) {

			if(cursos.get(i).getCodigo().contains(textFieldCodigo.getText())) {

				for(int j = 0; j < cursos.get(i).getAluno().size(); j++) {

					for(int k = 0; k < cursos.get(i).getAluno().get(j).getDisciplinaRealizadas().size(); k++) {

						for(int l = 0; l <  cursos.get(i).getAluno().get(j).getDisciplinaRealizadas().get(k).getAulas().size(); l++) {
							cargaHorariaRealizada +=  cursos.get(i).getAluno().get(j).getDisciplinaRealizadas().get(k).getAulas().get(l).getDuracao();

							if(cargaHorariaRealizada >= duracaoCurso)													
								alunosTela.put(alunos.get(j).getNome(), "Curso concluído");

						}

					}



				}
			}

		}

		System.out.println("carga horaria " + cargaHorariaRealizada);

		JFrame frame = new JFrame();

		// Frame Title
		frame.setTitle("Ex-Alunos");



		JTable table = new JTable(alunosTela.size(),2);
		int linha = 0;
		for(Entry<String, String> entry: alunosTela.entrySet()){
			table.setValueAt(entry.getKey(),linha,0);
			table.setValueAt(entry.getValue(),linha,1);

			linha++;
		}

		frame.setBounds(30, 40, 200, 300);

		// adding it to JScrollPane
		JScrollPane scrollPanel = new JScrollPane(table);
		frame.add(scrollPanel);
		// Frame Size
		frame.setSize(500, 200);
		// Frame Visible = true
		frame.setVisible(true);
		
	}


	public void criarNovaDisciplina(HashSet<String> codigoCurso, HashSet<String> codigoDisciplina, ArrayList<Curso> cursos, HashSet<String> CPF,
			ArrayList<Disciplina> disciplinas, ArrayList<Horario> horariosDisciplina, int contadorDataNova, JTextField textFieldData,
			JTextField textFieldCodigoCurso, JTextField textFieldHorarioDisciplina,
			JTextField textFieldCodigoDisciplina, JTextField textFieldSigla, JTextField textFieldNome, JTextField textFieldNomeDocente, JTextField textFieldCPFDocente, JTextField textFieldHorasDisciplina, SimpleDateFormat formatHorarioDisciplina, SimpleDateFormat formatDataDisciplina, int contadorDisciplinaNova, JFrame frame) {
Disciplina disciplina = new Disciplina();
		
		if(textFieldCodigoCurso.getText() != null && !textFieldCodigoCurso.getText().isEmpty()) {

			if(codigoCurso.contains(textFieldCodigoCurso.getText()) && !codigoDisciplina.contains(textFieldCodigoDisciplina.getText())) {
			
				
			if(textFieldCodigoDisciplina.getText() != null && !textFieldCodigoDisciplina.getText().isEmpty()) {

				codigoDisciplina.add(textFieldCodigoDisciplina.getText());
				disciplina.setCodigo(codigoDisciplina);


				System.out.println("Código cadastrado");

			}else {

				JOptionPane.showMessageDialog(frame, "Erro: Códogo de disciplina inválido");
			}

			if(textFieldSigla.getText() != null && !textFieldSigla.getText().isEmpty()) {

				disciplina.setSigla(textFieldSigla.getText());
				System.out.println("Sigla cadastrado");

			}else {

				JOptionPane.showMessageDialog(frame, "Erro: Sigla inválida");
			}

			if(textFieldNome.getText() != null && !textFieldNome.getText().isEmpty()) {

				disciplina.setNome(textFieldNome.getText());
				System.out.println("Nome da disciplina cadastrado");

			}else {

				JOptionPane.showMessageDialog(frame, "Erro: Nome da disciplina inválido");
			}

			if(textFieldNomeDocente.getText() != null && !textFieldNomeDocente.getText().isEmpty()) {

				disciplina.setDocente(new Docente());
				disciplina.getDocente().setNome(textFieldNomeDocente.getText());

				//for(int j = 0; j < disciplinas.size(); j++) {
				//	if(disciplinas.get(j).getCodigo().contains(textFieldCodigoDisciplina.getText())){

				//	}

				//	}
				System.out.println("Nome do docente cadastrado");

			}else {

				JOptionPane.showMessageDialog(frame, "Erro: Nome do docente inválido");
			}


			/*if(textFieldAula.getText() != null && !textFieldAula.getText().isEmpty()) {

					

.
					disciplina.setDatas();(textFieldAula.getText());
					System.out.println("data da primeira aula cadastrada");

				}else {

					JOptionPane.showMessageDialog(frame, "Erro: Nome da disciplina inválido");
				}*/

			if(textFieldCPFDocente.getText() != null && !textFieldCPFDocente.getText().isEmpty()) {

				if(textFieldCPFDocente.getText().equals("00000000000") ||
						textFieldCPFDocente.getText().equals("11111111111") ||
						textFieldCPFDocente.getText().equals("22222222222") || 
						textFieldCPFDocente.getText().equals("33333333333") ||
						textFieldCPFDocente.getText().equals("44444444444") || 
						textFieldCPFDocente.getText().equals("55555555555") ||
						textFieldCPFDocente.getText().equals("66666666666") || 
						textFieldCPFDocente.getText().equals("77777777777") ||												
						textFieldCPFDocente.getText().equals("88888888888") ||
						textFieldCPFDocente.getText().equals("99999999999")) {

					JOptionPane.showMessageDialog(frame, "Erro: CPF inválido");

				}else if(textFieldCPFDocente.getText().length() != 11) {

					JOptionPane.showMessageDialog(frame, "Erro: CPF inválido");

				}

				char[] CPFChar = textFieldCPFDocente.getText().toCharArray();

				for(int i = 0; i < CPFChar.length; i++) {

					if(CPFChar[i] != '1' && CPFChar[i] != '2' && CPFChar[i] != '3' &&
							CPFChar[i] != '4' && CPFChar[i] != '5' && CPFChar[i] != '6' &&
							CPFChar[i] != '7' && CPFChar[i] != '8' && CPFChar[i] != '9' &&
							CPFChar[i] != '0')
						JOptionPane.showMessageDialog(frame, "Erro: CPF inválido");

				}

				CPF.add(textFieldCPFDocente.getText());
				disciplina.getDocente().setCpf(CPF);

			}else {

				JOptionPane.showMessageDialog(frame, "Erro: CPF inválido");
			}

			if(textFieldHorasDisciplina.getText() != null && !textFieldHorasDisciplina.getText().isEmpty()) {
				Aula aula = new Aula();

				int horas = Integer.parseInt(textFieldHorasDisciplina.getText());

				if(horas > 4)
					horas = 4;
				if(horas < 0)
					horas = 1;

				aula.setDuracao(horas);
				aulas.add(aula);
				disciplina.setAulas(aulas);
				System.out.println("Hora/aula cadastrada " + aula.getDuracao());

			}else {

				JOptionPane.showMessageDialog(frame, "Erro: Nome do docente inválido");
			}
			if(textFieldData.getText() != null && !textFieldData.getText().isEmpty()) {
			
					try {															
															
						formatDataDisciplina.parse(textFieldData.getText());
						disciplina.setDatas(datas);	
						disciplina.getDatas().add(textFieldData.getText());
																
						System.out.println(disciplina.getDatas().get(0));
						
						System.out.println("Data/aula cadastrada " + disciplina.getDatas().get(contadorDataNova));
						contadorDataNova++;

					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					

			}else {

				JOptionPane.showMessageDialog(frame, "Erro: Data inválida");
			}

			if(textFieldHorarioDisciplina.getText() != null && !textFieldHorarioDisciplina.getText().isEmpty()) {

				Horario horarioDisciplina = new Horario();

				try {
					formatHorarioDisciplina.parse(textFieldHorarioDisciplina.getText());
					horarioDisciplina.setHorario(textFieldHorarioDisciplina.getText());	
					horariosDisciplina.add(horarioDisciplina);
					disciplina.setHorarios(horariosDisciplina);
					System.out.println("Horário cadastrado " + horarioDisciplina.getHorario());

					for(int i = 0; i < disciplinas.size(); i++) {

						if(disciplinas.contains(textFieldCodigoDisciplina.getText())) {

							disciplinas.get(i).setHorarios(horariosDisciplina);
						}													
					}

				} catch (ParseException e1) {
					e1.printStackTrace();
				}

				disciplina.setAulas(aulas);

				if(textFieldCodigoCurso.getText() != null && !textFieldCodigoCurso.getText().isEmpty()) {

					for(int j = 0; j < cursos.get(j).getCodigo().size(); j++) {

						if(cursos.get(j).getCodigo().contains(textFieldCodigoCurso.getText())) {

							disciplinas.add(disciplina);

							cursos.get(j).setDisciplina(disciplinas);
							JOptionPane.showMessageDialog(frame, "Cadastro realizado");
							System.out.println("Cadastro realizado: " + cursos.get(j).getDisciplina().get(contadorDisciplinaNova));								
							contadorDisciplinaNova++;											
							break;		

						}
					}

				}else {

					JOptionPane.showMessageDialog(frame, "Erro: Códogo de curso inválido");
				}




			}else {

				JOptionPane.showMessageDialog(frame, "Erro: Códogo horário inválido");
			}

		}else {
			JOptionPane.showMessageDialog(frame, "Disciplina já cadastrada");
		}

	}else {

		JOptionPane.showMessageDialog(frame, "Erro: Código não cadastrado");
	}
		
		
	}


	public void removerDisciplina(ArrayList<Curso> cursos, ArrayList<Disciplina> disciplinas,
			JTextField textFieldCodigoCurso, JTextField textFieldCodigo) {

		for(int i = 0; i < cursos.size(); i++) {

			if(cursos.get(i).getCodigo().contains(textFieldCodigoCurso.getText())) {

				for(int j = 0; j < disciplinas.size(); j++) {

					if(disciplinas.get(i).getCodigo().contains(textFieldCodigo.getText())) {
						
						disciplinas.remove(i);
						
						cursos.get(i).setDisciplina(disciplinas);
						
						System.out.println("Remoção realizada");
					
					}

				}
			}

		}		
	}





}
