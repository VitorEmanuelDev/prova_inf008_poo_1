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
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import model.Disciplina;

public class EditarDisciplina extends Menu{

	public void alterarDisciplina(JMenu menu, HashSet<String> codigoDisciplina, ArrayList<Disciplina> disciplinas) {

		JMenuItem menuItem;
		JMenu submenu;

		//a submenu
		menu.addSeparator();
		submenu = new JMenu("Disciplina");
		submenu.setMnemonic(KeyEvent.VK_S);

		menuItem = new JMenuItem("Nome");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_2, ActionEvent.ALT_MASK));
		submenu.add(menuItem);
		menuItem.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				final JFrame frame = new JFrame("Preencha o novo nome da disciplina");

				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setSize(350, 200);
				frame.setVisible(true);

				JFrame.setDefaultLookAndFeelDecorated(true);

				JLabel labelNome = new JLabel("Qual no novo nome?");
				labelNome.setBounds(30, 30, 400, 30);
				JTextField textFieldNome = new JTextField();
				//set size of the text box
				textFieldNome.setBounds(30, 60, 150, 30);
				//add elements to the frame
				frame.add(labelNome);
				frame.add(textFieldNome);

				JLabel labelCodigo = new JLabel("Informe o código da disciplina?");
				labelCodigo.setBounds(30, 90, 400, 30);
				JTextField textFieldCodigo = new JTextField();
				//set size of the text box
				textFieldCodigo.setBounds(30, 120, 150, 30);
				//add elements to the frame
				frame.add(labelCodigo);
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

							for(int i = 0; i < disciplinas.size(); i++) {

								if(disciplinas.get(i).getCodigo().contains(textFieldCodigo.getText())) {

									disciplinas.get(i).setNome(textFieldNome.getText());
									System.out.println("Nome da disciplina alterado " + disciplinas.get(i).getNome());

								}

							}

						}

						JOptionPane.showMessageDialog(frame, "Cadastro realizado!");

					}

				});
			}
		});

		menuItem = new JMenuItem("Modificar carga horária");
		submenu.add(menuItem);
		menu.add(submenu);


		menuItem.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				final JFrame frame = new JFrame("Preencha o novo horário ");

				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setSize(350, 200);
				frame.setVisible(true);

				//JFrame.setDefaultLookAndFeelDecorated(true);

				JLabel labelNome = new JLabel("Qual a nova carga horária? > 30 ou < 90");
				labelNome.setBounds(30, 30, 400, 30);
				JTextField textFieldCargaHoraria = new JTextField();
				//set size of the text box
				textFieldCargaHoraria.setBounds(30, 60, 150, 30);
				//add elements to the frame
				frame.add(labelNome);
				frame.add(textFieldCargaHoraria);

				JLabel labelCodigo = new JLabel("Informe o código da disciplina?");
				labelCodigo.setBounds(30, 90, 400, 30);
				JTextField textFieldCodigo = new JTextField();
				//set size of the text box
				textFieldCodigo.setBounds(30, 120, 150, 30);
				//add elements to the frame
				frame.add(labelCodigo);
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

						JOptionPane.showMessageDialog(frame, "Cadastro realizado!");

					}

				});
			}
		});


		menuItem = new JMenuItem("Horários");
		submenu.add(menuItem);
		menu.add(submenu);

		menuItem.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				final JFrame frame = new JFrame("Informe o novo horário");

				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setSize(350, 300);
				frame.setVisible(true);

				JFrame.setDefaultLookAndFeelDecorated(true);

				JLabel labelHorario = new JLabel("Qual horário deseja modificar? HH:mm");
				labelHorario.setBounds(30, 30, 400, 30);
				JTextField textFieldHorario = new JTextField();
				//set size of the text box
				textFieldHorario.setBounds(30, 60, 150, 30);
				//add elements to the frame
				frame.add(labelHorario);
				frame.add(textFieldHorario);

				JLabel labelHorarioNovo = new JLabel("Qual o novo horário? HH:mm");
				labelHorarioNovo.setBounds(30, 90, 400, 30);
				JTextField textFieldHorarioNovo = new JTextField();
				//set size of the text box
				textFieldHorarioNovo.setBounds(30, 120, 150, 30);
				//add elements to the frame
				frame.add(labelHorarioNovo);
				frame.add(textFieldHorarioNovo);

				JLabel labelCodigo = new JLabel("Informe o código da disciplina");
				labelCodigo.setBounds(30, 150, 400, 30);
				JTextField textFieldCodigo = new JTextField();
				//set size of the text box
				textFieldCodigo.setBounds(30, 180, 150, 30);
				//add elements to the frame
				frame.add(labelCodigo);
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

						JOptionPane.showMessageDialog(frame, "Cadastro realizado!");

					}

				});
			}
		});

		menuItem = new JMenuItem("Datas");
		submenu.add(menuItem);
		menu.add(submenu);


		menuItem.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				final JFrame frame = new JFrame("Informe a nova data");

				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setSize(350, 300);
				frame.setVisible(true);

				JFrame.setDefaultLookAndFeelDecorated(true);

				JLabel labelDataAntiga = new JLabel("Qual data deseja modificar? dd-MM-yyyy");
				labelDataAntiga.setBounds(30, 30, 400, 30);
				JTextField textFieldDataAntiga = new JTextField();
				//set size of the text box
				textFieldDataAntiga.setBounds(30, 60, 150, 30);
				//add elements to the frame
				frame.add(labelDataAntiga);
				frame.add(textFieldDataAntiga);

				JLabel labelDataNova = new JLabel("Qual a nova data? dd-MM-yyyy");
				labelDataNova.setBounds(30, 90, 400, 30);
				JTextField textFieldDataNova = new JTextField();
				//set size of the text box
				textFieldDataNova.setBounds(30, 120, 150, 30);
				//add elements to the frame
				frame.add(labelDataNova);
				frame.add(textFieldDataNova);

				JLabel labelCodigo = new JLabel("Informe o código da disciplina");
				labelCodigo.setBounds(30, 150, 400, 30);
				JTextField textFieldCodigo = new JTextField();
				//set size of the text box
				textFieldCodigo.setBounds(30, 180, 150, 30);
				//add elements to the frame
				frame.add(labelCodigo);
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

						JOptionPane.showMessageDialog(frame, "Cadastro realizado!");

					}

				});
			}
		});


		menuItem = new JMenuItem("Docente");
		submenu.add(menuItem);
		menu.add(submenu);


		menuItem.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				final JFrame frame = new JFrame("Novo docente");

				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setSize(350, 400);
				frame.setVisible(true);

				//JFrame.setDefaultLookAndFeelDecorated(true);

				JLabel labelNome = new JLabel("Informe o nome do novo docente");
				labelNome.setBounds(30, 30, 400, 30);
				JTextField textFieldNome = new JTextField();
				//set size of the text box
				textFieldNome.setBounds(30, 60, 150, 30);
				//add elements to the frame
				frame.add(labelNome);
				frame.add(textFieldNome);

				JLabel labelCPFAtual = new JLabel("Qual o CPF do atual docente?");
				labelCPFAtual.setBounds(30, 90, 400, 30);
				JTextField textFieldCPFAtual = new JTextField();
				//set size of the text box
				textFieldCPFAtual.setBounds(30, 120, 150, 30);
				//add elements to the frame
				frame.add(labelCPFAtual);
				frame.add(textFieldCPFAtual);

				JLabel labelCodigo = new JLabel("Informe o código da disciplina:");
				labelCodigo.setBounds(30, 150, 400, 30);
				JTextField textFieldCodigo = new JTextField();
				//set size of the text box
				textFieldCodigo.setBounds(30, 180, 150, 30);
				//add elements to the frame
				frame.add(labelCodigo);
				frame.add(textFieldCodigo);

				JLabel labelCPF = new JLabel("Informe o CPF do novo docente:");
				labelCPF.setBounds(30, 210, 400, 30);
				JTextField textFieldCPF = new JTextField();
				//set size of the text box
				textFieldCPF.setBounds(30, 240, 150, 30);
				//add elements to the frame
				frame.add(labelCPF);
				frame.add(textFieldCPF);

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

						JOptionPane.showMessageDialog(frame, "Cadastro realizado!");

					}

				});
			}
		});

	}

}
