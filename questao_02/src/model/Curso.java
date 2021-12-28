package model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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


	public void cadastrarNota(ArrayList<Curso> cursos, ArrayList<Disciplina> disciplinasRealizadas,
			JTextField textCodigoCurso, JTextField textCodigoDisciplina, JTextField textCPF, JTextField textNota, JFrame frame) {
		
		if(textCodigoCurso.getText() != null && !textCodigoCurso.getText().isEmpty()) {
			
			if(textCodigoDisciplina.getText() != null && !textCodigoDisciplina.getText().isEmpty()) {
				
				if(textCPF.getText() != null && !textCPF.getText().isEmpty()) {
					
					if(textNota.getText() != null && !textNota.getText().isEmpty()) {
						

						for(int i = 0; i < cursos.size(); i++){
							if(cursos.get(i).getCodigo().contains(textCodigoCurso.getText())) {
								
								for(int j = 0; j < cursos.get(i).getDisciplina().size(); j++){
									if(cursos.get(i).getDisciplina().get(j).getCodigo().contains(textCodigoDisciplina.getText())) {
																																							
										disciplinasRealizadas.add(cursos.get(i).getDisciplina().get(j));	

										for(int k = 0; k < cursos.get(i).getAluno().size(); k++){
											if(cursos.get(i).getAluno().get(k).getCpf().contains(textCPF.getText())) {
												
												cursos.get(i).getAluno().get(k).setDisciplinaRealizadas(disciplinasRealizadas);
												for(int l = 0; l < cursos.get(i).getAluno().get(k).getDisciplinaRealizadas().size(); l++){
													
													if(cursos.get(i).getDisciplina().get(j).getCodigo().contains(textCodigoDisciplina.getText())) {
														
														float nota = Float.parseFloat(textNota.getText());

														if(nota < 0)
															nota = 0;
														if(nota > 10)
															nota = 10;

														cursos.get(i).getAluno().get(k).getDisciplinaRealizadas().get(l).setNota(nota);
														System.out.println("Cadastro de nota realizado " + cursos.get(i).getAluno().get(k).getDisciplinaRealizadas().get(l).getNota());

														float cargaHoraria = 0;
														
														for(int m = 0; m < cursos.get(i).getAluno().get(k).getDisciplinaRealizadas().get(k).getAulas().size(); m++){

															float horas = cursos.get(i).getAluno().get(k).getDisciplinaRealizadas().get(k).getAulas().get(m).getDuracao();
																															
															cargaHoraria += horas;																																							
																																																								
														}
														
														cursos.get(i).getAluno().get(k).setTotalCargaHorariaCumprida(cargaHoraria);
														System.out.println("Cadastro de carga horária realizado " + cursos.get(i).getAluno().get(k).getTotalCargaHorariaCumprida());
													

													}
												}

											}



										}

									}

								}

							}
						}

					}else {
						JOptionPane.showMessageDialog(frame, "Erro: Nota inválida!");
					}
				}else {
					JOptionPane.showMessageDialog(frame, "Erro: CPF inválido!");
				}
			}else {
				JOptionPane.showMessageDialog(frame, "Erro: Código disciplina inválida!");
			}

		}else {
			JOptionPane.showMessageDialog(frame, "Erro: Código curso inválido!");
		}
		
	}




	public void matricularAlunoDisciplina(ArrayList<Curso> cursos, ArrayList<Disciplina> disciplinasInscritas, JTextField textCodigoCurso,
			JTextField textFieldCodigoDisciplina, JTextField textCPFAluno, JFrame frame) {
		
		if(textCodigoCurso.getText() != null && !textCodigoCurso.getText().isEmpty()) {

			if(textFieldCodigoDisciplina.getText() != null && !textFieldCodigoDisciplina.getText().isEmpty()) {

				if(textCPFAluno.getText() != null && !textCPFAluno.getText().isEmpty()) {


					for(int i = 0; i < cursos.size(); i++) {

						for(int j = 0; j < cursos.get(i).getDisciplina().size(); j++) {


							if(cursos.get(i).getDisciplina().get(j).getCodigo().contains(textFieldCodigoDisciplina.getText())) {

								//System.out.println(cursos.get(i).getAluno().get(0).getCpf().toString());

								for (int k = 0; k < alunos.size(); k++) {

									if(alunos.get(k).getCpf().contains(textCPFAluno.getText())) {
									
										System.out.println("legit " +cursos.get(i).getDisciplina().get(j).getDatas());
										disciplinasInscritas.add(cursos.get(i).getDisciplina().get(j));													
										alunos.get(k).setDisciplinasInscritas(disciplinasInscritas);
										System.out.println(alunos.get(k).getDisciplinasInscritas().get(0).getDatas());
										System.out.println("Aluno matriculado no disciplina " + alunos.get(k).getDisciplinasInscritas());
									}
								}
							}
						}
					}
					//08:00-12:00

					//14:00-18:00


				}else {

					JOptionPane.showMessageDialog(frame, "Erro: CPF inválido");
				}


			}else {

				JOptionPane.showMessageDialog(frame, "Erro: Código não encontrado");
			}


		}else {

			JOptionPane.showMessageDialog(frame, "Erro: Código não cadastrado");
		}
		
	}




	public void matricularAlunoCurso(ArrayList<Curso> cursos, HashSet<String> codigoCurso, HashSet<String> CPF,
			ArrayList<Aluno> alunos, Aluno aluno, JTextField textCodigoCurso, JTextField textCPFAluno, JTextField textNomeAluno, JFrame frame) {
		if(textCodigoCurso.getText() != null && !textCodigoCurso.getText().isEmpty()) {

			if(codigoCurso.contains(textCodigoCurso.getText())) {
				if(textCPFAluno.getText() != null && !textCPFAluno.getText().isEmpty()) {

					if(textCPFAluno.getText().equals("00000000000") ||
							textCPFAluno.getText().equals("11111111111") ||
							textCPFAluno.getText().equals("22222222222") ||
							textCPFAluno.getText().equals("33333333333") ||											
							textCPFAluno.getText().equals("44444444444") || 
							textCPFAluno.getText().equals("55555555555") ||
							textCPFAluno.getText().equals("66666666666") || 
							textCPFAluno.getText().equals("77777777777") ||
							textCPFAluno.getText().equals("88888888888") ||
							textCPFAluno.getText().equals("99999999999")) {

						JOptionPane.showMessageDialog(frame, "Erro: CPF inválido");

					}else if(textCPFAluno.getText().length() != 11) {

						JOptionPane.showMessageDialog(frame, "Erro: CPF inválido");

					}

					char[] CPFChar = textCPFAluno.getText().toCharArray();

					for(int i = 0; i < CPFChar.length; i++) {

						if(CPFChar[i] != '1' && CPFChar[i] != '2' && CPFChar[i] != '3' &&
								CPFChar[i] != '4' && CPFChar[i] != '5' && CPFChar[i] != '6' &&
								CPFChar[i] != '7' && CPFChar[i] != '8' && CPFChar[i] != '9' &&
								CPFChar[i] != '0')
							JOptionPane.showMessageDialog(frame, "Erro: CPF inválido");

					}

					CPF.add(textCPFAluno.getText());
					aluno.setCpf(CPF);

				}else {

					JOptionPane.showMessageDialog(frame, "Erro: CPF inválido");
				}

				if(textNomeAluno.getText() != null && !textNomeAluno.getText().isEmpty()) {

					aluno.setNome(textNomeAluno.getText());

				}else {

					JOptionPane.showMessageDialog(frame, "Erro: CPF inválido");
				}

			}else {

				JOptionPane.showMessageDialog(frame, "Erro: Código não encontrado");
			}



		}else {

			JOptionPane.showMessageDialog(frame, "Erro: Código não cadastrado");
		}


		alunos.add(aluno);
		for(int i = 0; i < cursos.size(); i++) {
			if(cursos.get(i).getCodigo().contains(textCodigoCurso.getText()))
				cursos.get(i).setAluno(alunos);
		}
		
	}




	public void mostrarHorarioAulaAluno(ArrayList<Aluno> alunos2, JTextField textCPFAluno) {
		HashMap<String, ArrayList<Horario>> agendaAluno = new HashMap<String, ArrayList<Horario>>();

		for(int i = 0; i < alunos.size(); i++) {

			if(alunos.get(i).getCpf().contains(textCPFAluno.getText())) {

				for(int j = 0; j < alunos.get(i).getDisciplinasInscritas().size(); j++) {

					System.out.println("1" + alunos.get(i).getDisciplinasInscritas().get(j).getDatas());

					for(int k = 0; k < alunos.get(i).getDisciplinasInscritas().get(j).getDatas().size(); k++) {

						while(k < alunos.get(i).getDisciplinasInscritas().get(j).getHorarios().size()) {

							agendaAluno.put(alunos.get(i).getDisciplinasInscritas().get(j).getDatas().get(k),  alunos.get(i).getDisciplinasInscritas().get(j).getHorarios());											}
						k++;
					
					}

				}

			}

		}

		JFrame frame = new JFrame();

		// Frame Title
		frame.setTitle("Datas e horários");
		
		

		JTable table = new JTable(agendaAluno.size(),2);
		int linha = 0;
		for(HashMap.Entry<String,ArrayList<Horario>> entry: agendaAluno.entrySet()){
			table.setValueAt(entry.getKey(),linha,0);
			for(int i = 0; i< entry.getValue().size(); i++) {
				table.setValueAt(entry.getValue().get(i).getHorario(),linha,1);
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
	}




	public void criarNovoCurso(HashSet<String> codigoCurso, JTextField textFieldCodigo, JTextField textFieldCurso,
			JTextField textFieldHorario, SimpleDateFormat formatHorarioCurso, ArrayList<Horario> horariosCurso,
			int contadorCursoNovo, ArrayList<Curso> cursos, JFrame frame) {
		if(!codigoCurso.contains(textFieldCodigo.getText())) {
			Curso curso = new Curso();

			if(textFieldCurso.getText() != null && !textFieldCurso.getText().isEmpty()) {

				curso.setNome(textFieldCurso.getText());
				System.out.println("Cadastro de nome realizado: " + curso.getNome());

			}else {

				JOptionPane.showMessageDialog(frame, "Erro: Nome de curso inválido");
			}

			if(textFieldCodigo.getText() != null && !textFieldCodigo.getText().isEmpty()) {
				codigoCurso.add(textFieldCodigo.getText());
				curso.setCodigo(codigoCurso);
				System.out.println("Cadastro de código realizado: " + curso.getCodigo());
			}else {

				JOptionPane.showMessageDialog(frame, "Erro: Código inválido");
			}

			if(textFieldHorario.getText() != null && !textFieldHorario.getText().isEmpty()) {
				Horario horarioCurso = new Horario();		

				try {			
					formatHorarioCurso.parse(textFieldHorario.getText());
					horarioCurso.setHorario(textFieldHorario.getText());
					horariosCurso.add(horarioCurso);

				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(frame, "Erro: Horário inválido");
					e1.printStackTrace();
				}

				curso.setHorarios(horariosCurso);

				System.out.println("Cadastro de horario realizado: " + curso.getHorarios().get(contadorCursoNovo).getHorario());								
				JOptionPane.showMessageDialog(frame, "Cadastro realizado!");
				contadorCursoNovo++;
			}else {

				JOptionPane.showMessageDialog(frame, "Erro: Horário inválido");
			}

			cursos.add(curso);

		}else {
			JOptionPane.showMessageDialog(frame, "Curso já existe!");
		}
		
	}


	public void cadastrarNovoHorario(ArrayList<Curso> cursos, JTextField textFieldHorario, JTextField textFieldCodigo,
			SimpleDateFormat formatHorarioCurso, JFrame frame) {
		if(textFieldHorario.getText() != null && !textFieldHorario.getText().isEmpty()) {

			if(textFieldCodigo.getText() != null && !textFieldCodigo.getText().isEmpty()) {
				//System.out.println(textFieldCodigo.getText());
					Horario horarioCurso = new Horario();
					
					for(int j = 0; j < cursos.get(j).getCodigo().size(); j++) {

						if(cursos.get(j).getCodigo().contains(textFieldCodigo.getText())) {
						
							try {			
								formatHorarioCurso.parse(textFieldHorario.getText());
								horarioCurso.setHorario(textFieldHorario.getText());
								cursos.get(j).getHorarios().add(horarioCurso);
								
							} catch (ParseException e1) {
								e1.printStackTrace();
							}

							System.out.println("Cadastro de horario realizado: " + cursos.get(j).getHorarios().get(cursos.get(j).getHorarios().size() - 1).getHorario() );								
							JOptionPane.showMessageDialog(frame, "Cadastro realizado!");
							break;		

						}
					}
				}else {

					JOptionPane.showMessageDialog(frame, "Erro: Código inválido");
				}

			}else {

				JOptionPane.showMessageDialog(frame, "Erro: Horário inválido");
			}
		
	}
	
}
