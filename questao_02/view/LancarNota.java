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

import model.Aluno;
import model.Curso;
import model.Disciplina;
import model.Horario;

public class LancarNota extends Menu{


	public void lancarNota(JMenu menu, ArrayList<Curso> cursos, ArrayList<Aluno> alunos, HashSet<String> cPF, HashSet<String> codigoCurso, HashSet<String> codigoDisciplina, ArrayList<Disciplina> disciplinasRealizadas){

		JMenuItem menuItem; 

		menuItem = new JMenuItem("Lançar notas...",
				new ImageIcon("images/newfile.png"));
		menuItem.setMnemonic(KeyEvent.VK_F);
		menu.add(menuItem);


		menuItem.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				final JFrame frame = new JFrame("Lançamento de notas");

				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setSize(310, 350);
				frame.setVisible(true);

				JFrame.setDefaultLookAndFeelDecorated(true);


				JLabel labelCodigoCurso = new JLabel("Informe o código do curso");
				labelCodigoCurso.setBounds(30, 30, 200, 30);
				JTextField textCodigoCurso = new JTextField();
				//set size of the text box
				textCodigoCurso.setBounds(30, 60, 150, 30);
				//add elements to the frame
				frame.add(labelCodigoCurso);
				frame.add(textCodigoCurso);

				JLabel labelCodigoDisciplina = new JLabel("Informe o código da disciplina");
				labelCodigoDisciplina.setBounds(30, 90, 250, 30);
				JTextField textCodigoDisciplina = new JTextField();
				//set size of the text box
				textCodigoDisciplina.setBounds(30, 120, 150, 30);
				//add elements to the frame
				frame.add(labelCodigoDisciplina);
				frame.add(textCodigoDisciplina);

				JLabel labelCPF = new JLabel("Informe o CPF do aluno");
				labelCPF.setBounds(30, 150, 200, 30);
				JTextField textCPF = new JTextField();
				//set size of the text box
				textCPF.setBounds(30, 180, 150, 30);
				//add elements to the frame
				frame.add(labelCPF);
				frame.add(textCPF);

				JLabel labelNota = new JLabel("Informe a nota obtida");
				labelNota.setBounds(30, 210, 200, 30);
				JTextField textNota = new JTextField();
				//set size of the text box
				textNota.setBounds(30, 240, 150, 30);
				//add elements to the frame
				frame.add(labelNota);
				frame.add(textNota);

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

						JOptionPane.showMessageDialog(frame, "Cadastro realizado!");

					}

				});

			}
		});
	}

}
