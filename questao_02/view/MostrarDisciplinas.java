package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import model.Aluno;
import model.Curso;
import model.Disciplina;
import model.Horario;

public class MostrarDisciplinas {

	public void mostrarDisciplinas(JMenu menu, ArrayList<Aluno> alunos, ArrayList<Disciplina> disciplinasRealizadas, ArrayList<Disciplina> disciplinasInscritas, ArrayList<Curso> cursos){

		JMenuItem menuItem;

		menuItem = new JMenuItem("Mostrar disiciplinas...",
				new ImageIcon("images/newfile.png"));
		menuItem.setMnemonic(KeyEvent.VK_F);
		menu.add(menuItem);

		menuItem.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				final JFrame frame = new JFrame("Horário por");

				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setSize(310, 280);
				frame.setVisible(true);

				//JFrame.setDefaultLookAndFeelDecorated(true);

				JLabel labelCursoCodigo = new JLabel("Informe o código do curso");
				labelCursoCodigo.setBounds(30, 30, 200, 30);
				JTextField textCursoCodigo = new JTextField();
				//set size of the text box
				textCursoCodigo.setBounds(30, 60, 150, 30);
				//add elements to the frame
				frame.add(labelCursoCodigo);
				frame.add(textCursoCodigo);


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


							HashMap<String, ArrayList<Disciplina>> alunoDisciplinasInscritasOuACursar = new HashMap<String, ArrayList<Disciplina>>();
							
							HashMap<String, ArrayList<Disciplina>> alunoDisciplinasRealizadas = new HashMap<String, ArrayList<Disciplina>>();
/*
							float duracaoCurso = 0;
							for(int i = 0; i < cursos.size(); i++) {
								if(cursos.get(i).getCodigo().contains(textCursoCodigo.getText())){
									for(int j = 0; j < cursos.get(i).getDisciplina().size(); j++) {
										for(int k = 0; k < cursos.get(i).getDisciplina().get(j).getAulas().size(); k++) {
											duracaoCurso += cursos.get(i).getDisciplina().get(j).getAulas().get(k).getDuracao();
										}
									}

								}
							}
							
							float cargaHorariaRealizada = 0;
							for(int i = 0; i < cursos.size(); i++) {

								if(cursos.get(i).getCodigo().contains(textCursoCodigo.getText())) {

									for(int j = 0; j < cursos.get(i).getAluno().size(); j++) {

										for(int k = 0; k < cursos.get(i).getAluno().get(j).getDisciplinaRealizadas().size(); k++) {

											for(int l = 0; l <  cursos.get(i).getAluno().get(j).getDisciplinaRealizadas().get(k).getAulas().size(); l++) {
												cargaHorariaRealizada +=  cursos.get(i).getAluno().get(j).getDisciplinaRealizadas().get(k).getAulas().get(l).getDuracao();

												if(cargaHorariaRealizada < duracaoCurso)													
													alunosTela.put(alunos.get(j).getNome(), "Curso concluído");

											}

										}



									}
								}

							}*/
							
							
							for(int i = 0; i < cursos.size(); i++) {

								float totalHorasCurso = 0;

								for(int j = 0; j < cursos.get(i).getDisciplina().size(); j++) {

									for(int k = 0; k < cursos.get(i).getDisciplina().get(j).getAulas().size(); k++) {

										totalHorasCurso += cursos.get(i).getDisciplina().get(j).getAulas().get(k).getDuracao();

									}

									//System.out.println("\nLista de alunos de : " + cursos.get(i).getNome());
									for(int k = 0; k < cursos.get(i).getAluno().get(k).getTotalCargaHorariaCumprida(); k++) {

										if(cursos.get(i).getAluno().get(k).getTotalCargaHorariaCumprida() < totalHorasCurso) {

											System.out.println("- " + cursos.get(i).getAluno().get(k).getNome());
											
											

											//System.out.println("Matérias : ");
											//System.out.println(" - concluídas : ");
											for(int l = 0; l < cursos.get(i).getAluno().get(k).getDisciplinaRealizadas().size(); l++) {
												alunoDisciplinasRealizadas.put(cursos.get(i).getAluno().get(k).getNome(),cursos.get(i).getAluno().get(k).getDisciplinaRealizadas());
												System.out.println(" - " + cursos.get(i).getAluno().get(k).getDisciplinaRealizadas().get(l).getNome());
											}

											//System.out.println(" - cursando : ");
											for(int l = 0; l < cursos.get(i).getAluno().get(k).getDisciplinasInscritas().size(); l++) {
												alunoDisciplinasInscritasOuACursar.put(cursos.get(i).getAluno().get(k).getNome(),cursos.get(i).getAluno().get(k).getDisciplinasInscritas());
												System.out.println(" - " + cursos.get(i).getAluno().get(k).getDisciplinaRealizadas().get(l).getNome());
											}

											//System.out.println(" - a cursar : ");
											for(int l = 0; l < cursos.get(i).getDisciplina().size(); l++) {

												for(int m = 0; m < cursos.get(i).getAluno().get(k).getDisciplinaRealizadas().size(); m++) {

													String codigoRealizada = cursos.get(i).getAluno().get(k).getDisciplinaRealizadas().get(k).getCodigo().toString();
													String codigoCursando = cursos.get(i).getAluno().get(k).getDisciplinasInscritas().get(k).getCodigo().toString();

													if(!cursos.get(i).getDisciplina().get(l).getCodigo().contains(codigoRealizada) &&
															!cursos.get(i).getDisciplina().get(l).getCodigo().contains(codigoCursando)) {
														alunoDisciplinasInscritasOuACursar.put(cursos.get(i).getAluno().get(k).getNome(),cursos.get(i).getAluno().get(k).getDisciplinasInscritas());
														//System.out.println(" - " + cursos.get(i).getAluno().get(k).getDisciplinaRealizadas().get(l).getNome());
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
							frame.setTitle("Disciplinas a cursar");
							
							

							JTable table1 = new JTable(alunoDisciplinasRealizadas.size(),2);
							
							linha = 0;
							for(Entry<String, ArrayList<Disciplina>> entry: alunoDisciplinasRealizadas.entrySet()){
								table.setValueAt(entry.getKey(),linha,0);
								for(int i  = 0; i < entry.getValue().size(); i++) {
									table.setValueAt(entry.getValue().get(i).getNome(),linha,1);
								}
								linha++;
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


					}

				});

			}
		});

	}

}


