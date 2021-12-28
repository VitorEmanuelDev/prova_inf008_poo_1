package view;

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
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import model.Curso;
import model.Horario;

public class EditarCurso extends Menu{

	public void alterarCurso(JMenu menu, HashSet<String> codigoCurso, ArrayList<Curso> cursos) {

		JMenuItem menuItem;
		JMenu submenu;
		Curso curso = new Curso();

		menu.addSeparator();

		submenu = new JMenu("Curso...");
		submenu.setMnemonic(KeyEvent.VK_S);

		menuItem = new JMenuItem("Horário");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_2, ActionEvent.ALT_MASK));
		submenu.add(menuItem);

		menuItem.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				final JFrame frame = new JFrame("Preencha o novo horário");

				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setSize(420, 300);
				frame.setVisible(true);

				//JFrame.setDefaultLookAndFeelDecorated(true);

				JLabel labelHorario = new JLabel("Horário do curso que deseja alterar(HH:mm-HH:mm)");
				labelHorario.setBounds(30, 30, 400, 30);
				JTextField textFieldHorario = new JTextField();
				//set size of the text box
				textFieldHorario.setBounds(30, 60, 150, 30);
				//add elements to the frame
				frame.add(labelHorario);
				frame.add(textFieldHorario);

				JLabel labelNovoHorario = new JLabel("Qual o novo horário (HH:mm-HH:mm)");
				labelNovoHorario.setBounds(30, 90, 300, 30);
				JTextField textFieldNovoHorario = new JTextField();
				//set size of the text box
				textFieldNovoHorario.setBounds(30, 120, 150, 30);
				//add elements to the frame
				frame.add(labelNovoHorario);
				frame.add(textFieldNovoHorario);

				JLabel labelCodigo = new JLabel("Qual o código do curso");
				labelCodigo.setBounds(30, 150, 200, 30);
				JTextField textFielCodigo = new JTextField();
				//set size of the text box
				textFielCodigo.setBounds(30, 180, 150, 30);
				//add elements to the frame
				frame.add(labelCodigo);
				frame.add(textFielCodigo);

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
							curso.editarCurso(cursos, formatHorarioCurso, textFielCodigo, textFieldNovoHorario, textFieldHorario);		
						}

						JOptionPane.showMessageDialog(frame, "Cadastro realizado!");

					}

				});

			}
		});


		menuItem = new JMenuItem("Nome");
		submenu.add(menuItem);

		menuItem.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				final JFrame frame = new JFrame("Preencha o novo nome");

				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setSize(300, 280);
				frame.setVisible(true);

				//JFrame.setDefaultLookAndFeelDecorated(true);

				JLabel labelNome = new JLabel("Qual o novo nome do curso?");
				labelNome.setBounds(30, 30, 300, 30);
				JTextField textFieldNovoNome = new JTextField();
				//set size of the text box
				textFieldNovoNome.setBounds(30, 60, 150, 30);
				//add elements to the frame
				frame.add(labelNome);
				frame.add(textFieldNovoNome);

				JLabel labelCodigo = new JLabel("Qual o código do curso");
				labelCodigo.setBounds(30, 90, 200, 30);
				JTextField textFielCodigo = new JTextField();
				//set size of the text box
				textFielCodigo.setBounds(30, 120, 150, 30);
				//add elements to the frame
				frame.add(labelCodigo);
				frame.add(textFielCodigo);

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
							curso.mudarNomeCurso(cursos, textFielCodigo, textFieldNovoNome);
						}

						JOptionPane.showMessageDialog(frame, "Cadastro realizado!");

					}

				});
			}
		});

		menu.add(submenu);
	}

}
