package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import model.*;


public class MostrarHorarioPorAluno extends Menu{

	public void mostrarHorarioPorAluno(JMenu menu, ArrayList<Aluno> alunos, ArrayList<Disciplina> disciplinasInscritas){

		JMenuItem menuItem; 

		menuItem = new JMenuItem("Horários por aluno...",
				new ImageIcon("images/newproject.png"));
		menuItem.setMnemonic(KeyEvent.VK_P);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"New Project");
		menu.add(menuItem);

		menuItem.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				final JFrame frame = new JFrame("Horário por aluno");

				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setSize(310, 280);
				frame.setVisible(true);

				//JFrame.setDefaultLookAndFeelDecorated(true);

				JLabel labelCPFAluno = new JLabel("Informe o CPF do aluno");
				labelCPFAluno.setBounds(30, 30, 200, 30);
				JTextField textCPFAluno = new JTextField();
				//set size of the text box
				textCPFAluno.setBounds(30, 60, 150, 30);
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

						//JFrame.setDefaultLookAndFeelDecorated(true);

						if(e.getSource() == okButton) {




							HashMap<String, ArrayList<Horario>> agendaAluno = new HashMap<String, ArrayList<Horario>>();

							for(int i = 0; i < alunos.size(); i++) {

								if(alunos.get(i).getCpf().contains(textCPFAluno.getText())) {

									for(int j = 0; j < alunos.get(i).getDisciplinasInscritas().size(); j++) {

										System.out.println("1" + alunos.get(i).getDisciplinasInscritas().get(j).getDatas());

										for(int k = 0; k < alunos.get(i).getDisciplinasInscritas().get(j).getDatas().size(); k++) {

											for(int l = 0; k < alunos.get(i).getDisciplinasInscritas().get(j).getHorarios().size(); k++) {

												int nome = i;
												//alunos.get(i).getDisciplinasInscritas().get(j).getDatas().get(k);
												//alunos.get(i).getDisciplinasInscritas().get(j).getHorarios().get(k).getHorario();
												agendaAluno.put(alunos.get(i).getDisciplinasInscritas().get(j).getDatas().get(k),  alunos.get(i).getDisciplinasInscritas().get(j).getHorarios());											}
										
										
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


					}

				});

			}
		});

	}

}
