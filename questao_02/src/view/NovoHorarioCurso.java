package view;

import model.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

public class NovoHorarioCurso {
	
	public static SimpleDateFormat formatHorarioCurso = new SimpleDateFormat("HH:mm-HH:mm");


	//SimpleDateFormat formatHorarioCurso = new SimpleDateFormat("HH:mm-HH:mm");
	public void novoHorarioCurso(JMenu menu, ArrayList<Curso> cursos, HashSet<String> codigoCurso) {

		JMenuItem menuItem;
		//a group of JMenuItems
		menuItem = new JMenuItem("Novo horário...",
				new ImageIcon("images/newproject.png"));
		menuItem.setMnemonic(KeyEvent.VK_P);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_2, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"New Project");
		menu.add(menuItem);

		menuItem.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				final JFrame frame = new JFrame("Adicione um novo horário");

				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setSize(350, 280);
				frame.setVisible(true);

				//JFrame.setDefaultLookAndFeelDecorated(true);

				JLabel labelHorario = new JLabel("Novo horário do curso (HH:mm-HH:mm)");
				labelHorario.setBounds(30, 30, 400, 30);
				JTextField textFieldHorario = new JTextField();
				//set size of the text box
				textFieldHorario.setBounds(30, 60, 150, 30);
				//add elements to the frame
				frame.add(labelHorario);
				frame.add(textFieldHorario);

				JLabel labelCodigo = new JLabel("Código do curso");
				labelCodigo.setBounds(30, 90, 150, 30);
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

				

			});
		}
	});

}

}
