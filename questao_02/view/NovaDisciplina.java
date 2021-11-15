package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import model.Aula;
import model.Curso;
import model.Disciplina;
import model.Docente;
import model.Horario;

public class NovaDisciplina extends Menu{


	//private JMenu menu;

	public void novaDisciplina(JMenu menu, ArrayList<Curso> cursos, HashSet<String> CPF, HashSet<String> codigoCurso, HashSet<String> codigoDisciplina, ArrayList<Disciplina> disciplinas, ArrayList<Horario> horariosDisciplina, ArrayList<String> datas){

		JMenuBar menuBar;
		JMenuItem menuItem;

		menuItem = new JMenuItem("Nova disciplina...",
				new ImageIcon("images/newfile.png"));
		menuItem.setMnemonic(KeyEvent.VK_F);
		menu.add(menuItem);

		menuItem.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				final JFrame frame = new JFrame("Informe os dados da disciplina");

				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setSize(310, 700);
				frame.setVisible(true);

				//JFrame.setDefaultLookAndFeelDecorated(true);

				JLabel labelNome = new JLabel("Nome da disciplina");
				labelNome.setBounds(30, 30, 250, 30);
				JTextField textFieldNome = new JTextField();
				//set size of the text box
				textFieldNome.setBounds(30, 60, 150, 30);
				//add elements to the frame
				frame.add(labelNome);
				frame.add(textFieldNome);

				JLabel labelCodigo = new JLabel("Código da disciplina");
				labelCodigo.setBounds(30, 90, 250, 30);
				JTextField textFieldCodigoDisciplina = new JTextField();
				//set size of the text box
				textFieldCodigoDisciplina.setBounds(30, 120, 150, 30);
				//add elements to the frame
				frame.add(labelCodigo);
				frame.add(textFieldCodigoDisciplina);

				JLabel labelSigla = new JLabel("Sigla da disciplina");
				labelSigla.setBounds(30, 150, 250, 30);
				JTextField textFieldSigla = new JTextField();
				//set size of the text box
				textFieldSigla.setBounds(30, 180, 150, 30);
				//add elements to the frame
				frame.add(labelSigla);
				frame.add(textFieldSigla);

				JLabel labelDocente = new JLabel("Docente");
				labelDocente.setBounds(30, 210, 250, 30);
				JTextField textFieldNomeDocente = new JTextField();
				//set size of the text box
				textFieldNomeDocente.setBounds(30, 240, 150, 30);
				//add elements to the frame
				frame.add(labelDocente);
				frame.add(textFieldNomeDocente);

				JLabel labelCPFDocente = new JLabel("CPF dp docente");
				labelCPFDocente.setBounds(30, 270, 250, 30);
				JTextField textFieldCPFDocente = new JTextField();
				//set size of the text box
				textFieldCPFDocente.setBounds(30, 300, 150, 30);
				//add elements to the frame
				frame.add(labelCPFDocente);
				frame.add(textFieldCPFDocente);

				JLabel labelHorasDisciplina = new JLabel("Qual a hora/aula da primeira data?");
				labelHorasDisciplina.setBounds(30, 330, 250, 30);
				JTextField textFieldHorasDisciplina = new JTextField();
				//set size of the text box
				textFieldHorasDisciplina.setBounds(30, 360, 150, 30);
				//add elements to the frame
				frame.add(labelHorasDisciplina);
				frame.add(textFieldHorasDisciplina);

				JLabel labelHorarioDisciplina= new JLabel("Informe o horário da disciplina");
				labelHorarioDisciplina.setBounds(30, 390, 250, 30);
				JTextField textFieldHorarioDisciplina = new JTextField();
				//set size of the text box
				textFieldHorarioDisciplina.setBounds(30, 420, 150, 30);
				//add elements to the frame
				frame.add(labelHorarioDisciplina);
				frame.add(textFieldHorarioDisciplina);

				JLabel labelCodigoCurso = new JLabel("Informe o código do curso");
				labelCodigoCurso.setBounds(30, 450, 250, 30);
				JTextField textFieldCodigoCurso = new JTextField();
				//set size of the text box
				textFieldCodigoCurso.setBounds(30, 480, 150, 30);
				//add elements to the frame
				frame.add(labelCodigoCurso);
				frame.add(textFieldCodigoCurso);

				JLabel labelData= new JLabel("Qual a data da primeira aula?");
				labelData.setBounds(30, 510, 250, 30);
				JTextField textFieldData = new JTextField();
				//set size of the text box
				textFieldData.setBounds(30, 540, 150, 30);
				//add elements to the frame
				frame.add(labelData);
				frame.add(textFieldData);


				// Creating a new buttons
				JButton  okButton = new JButton("OK");


				// Creating a panel to add buttons
				JPanel panel = new JPanel();

				// Adding buttons and textfield to panel
				// using add() method
				panel.add(okButton);

				// Adding panel to frame
				frame.add(panel);

				frame.show();

				frame.setLayout(null);
				frame.setVisible(true);	

				okButton.addActionListener(new ActionListener() {

					@SuppressWarnings("deprecation")
					public void actionPerformed(ActionEvent e) {

						//JFrame.setDefaultLookAndFeelDecorated(true);

						if(e.getSource() == okButton) {
							
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

									JOptionPane.showMessageDialog(frame, "Erro: Nome do docente inválido");
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


				}

			});

		}



	});

}



}
