package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import model.Aluno;
import model.Aula;
import model.Curso;
import model.Disciplina;
import model.Docente;

public class MatricularAluno extends Menu{

	public void matricularAluno(JMenu menu, ArrayList<Curso> cursos, ArrayList<Aluno> alunos, HashSet<String> CPF,  HashSet<String> codigoCurso){

		JMenuBar menuBar;
		JMenu submenu;
		JMenuItem menuItem; 

		//a submenu
		menu.addSeparator();
		submenu = new JMenu("Matricular aluno...");
		submenu.setMnemonic(KeyEvent.VK_S);

		menuItem = new JMenuItem("Em uma disciplina");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_2, ActionEvent.ALT_MASK));
		submenu.add(menuItem);

		menuItem.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				final JFrame frame = new JFrame("Matricula em disciplina");

				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setSize(250, 400);
				frame.setVisible(true);

				//JFrame.setDefaultLookAndFeelDecorated(true);

				JLabel labelCodigoDisciplina = new JLabel("Código da disciplina");
				labelCodigoDisciplina.setBounds(30, 30, 150, 30);
				JTextField textFieldCodigoDisciplina = new JTextField();
				//set size of the text box
				textFieldCodigoDisciplina.setBounds(30, 60, 150, 30);
				//add elements to the frame
				frame.add(labelCodigoDisciplina);
				frame.add(textFieldCodigoDisciplina);

				JLabel labelCodigoCurso = new JLabel("Informe o código do curso");
				labelCodigoCurso.setBounds(30, 90, 200, 30);
				JTextField textCodigoCurso = new JTextField();
				//set size of the text box
				textCodigoCurso.setBounds(30, 120, 150, 30);
				//add elements to the frame
				frame.add(labelCodigoCurso);
				frame.add(textCodigoCurso);

				JLabel labelCPFAluno = new JLabel("Informe o CPF do aluno");
				labelCPFAluno.setBounds(30, 150, 200, 30);
				JTextField textCPFAluno = new JTextField();
				//set size of the text box
				textCPFAluno.setBounds(30, 180, 150, 30);
				//add elements to the frame
				frame.add(labelCPFAluno);
				frame.add(textCPFAluno);


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


						if(textCodigoCurso.getText() != null && !textCodigoCurso.getText().isEmpty()) {

							if(textFieldCodigoDisciplina.getText() != null && !textFieldCodigoDisciplina.getText().isEmpty()) {

								if(textCPFAluno.getText() != null && !textCPFAluno.getText().isEmpty()) {


									for(int i = 0; i < cursos.size(); i++) {

										for(int j = 0; j < cursos.get(i).getDisciplina().size(); j++) {



											if(cursos.get(i).getDisciplina().get(j).getCodigo().contains(textFieldCodigoDisciplina.getText())) {

												//System.out.println(cursos.get(i).getAluno().get(0).getCpf().toString());

												for (int k = 0; k < cursos.get(i).getAluno().size(); k++) {

													if(cursos.get(i).getAluno().get(k).getCpf().contains(textCPFAluno.getText())) {
														
														System.out.println(cursos.get(i).getDisciplina().get(j));
														System.out.println(disciplinasInscritas.size());
														
														disciplinasInscritas.add(cursos.get(i).getDisciplina().get(j));
														//alunos.get(k).setDisciplinasInscritas(disciplinasInscritas);
														cursos.get(i).getAluno().get(k).setDisciplinasInscritas(disciplinasInscritas);

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

						JOptionPane.showMessageDialog(frame, "Cadastro realizado!");


					}

				});

			}

		});





		menuItem = new JMenuItem("Em um curso");
		submenu.add(menuItem);
		menu.add(submenu);

		menuItem.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				final JFrame frame = new JFrame("Matricula em curso");

				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setSize(310, 280);
				frame.setVisible(true);

				//JFrame.setDefaultLookAndFeelDecorated(true);


				JLabel labelCodigoCurso = new JLabel("Informe o código do curso");
				labelCodigoCurso.setBounds(30, 30, 200, 30);
				JTextField textCodigoCurso = new JTextField();
				//set size of the text box
				textCodigoCurso.setBounds(30, 60, 150, 30);
				//add elements to the frame
				frame.add(labelCodigoCurso);
				frame.add(textCodigoCurso);

				JLabel labelCPFAluno = new JLabel("Informe o CPF do aluno");
				labelCPFAluno.setBounds(30, 90, 200, 30);
				JTextField textCPFAluno = new JTextField();
				//set size of the text box
				textCPFAluno.setBounds(30, 120, 150, 30);
				//add elements to the frame
				frame.add(labelCPFAluno);
				frame.add(textCPFAluno);

				JLabel labelNomeAluno = new JLabel("Informe o nome do aluno");
				labelNomeAluno.setBounds(30, 150, 200, 30);
				JTextField textNomeAluno = new JTextField();
				//set size of the text box
				textNomeAluno.setBounds(30, 180, 150, 30);
				//add elements to the frame
				frame.add(labelNomeAluno);
				frame.add(textNomeAluno);

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

						Aluno aluno = new Aluno();

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

						System.out.println("Cadastro aluno realizado " + alunos.get(contadorAlunoNovo));
						contadorAlunoNovo++;

						JOptionPane.showMessageDialog(frame, "Cadastro realizado!");


					}

				});

			}
		});
	}
}
