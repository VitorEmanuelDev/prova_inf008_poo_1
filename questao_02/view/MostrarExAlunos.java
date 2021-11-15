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

import model.Aluno;
import model.Curso;
import model.Disciplina;
import model.Horario;

public class MostrarExAlunos {


	public void mostrarExAlunos(JMenu menu, ArrayList<Aluno> alunos, ArrayList<Disciplina> disciplinasRealizadas, ArrayList<Curso> cursos){

		JMenuItem menuItem;

		menuItem = new JMenuItem("Ex-Alunos...",
				new ImageIcon("images/newfile.png"));
		menuItem.setMnemonic(KeyEvent.VK_F);
		menu.add(menuItem);

		menuItem.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				final JFrame frame = new JFrame("Ex-Alunos");

				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setSize(310, 280);
				frame.setVisible(true);

				//JFrame.setDefaultLookAndFeelDecorated(true);

				JLabel labelCodigoCurso = new JLabel("Informe o código do curso");
				labelCodigoCurso.setBounds(30, 30, 200, 30);
				JTextField textFieldCodigo = new JTextField();
				//set size of the text box
				textFieldCodigo.setBounds(30, 60, 150, 30);
				//add elements to the frame
				frame.add(labelCodigoCurso);
				frame.add(textFieldCodigo);


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


					}

				});

			}
		});

	}

}

