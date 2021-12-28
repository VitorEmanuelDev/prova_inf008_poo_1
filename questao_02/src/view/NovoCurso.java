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
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import model.Curso;
import model.Horario;

public class NovoCurso extends Menu{
	


	public void novoCurso(JMenu menu, ArrayList<Curso> cursos, HashSet<String> codigoCurso) {

		JMenuItem menuItem; 
		Curso curso = new Curso();

		//a group of JMenuItems
		menuItem = new JMenuItem("Novo curso...",
				new ImageIcon("images/newproject.png"));
		menuItem.setMnemonic(KeyEvent.VK_P);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"New Project");
		menu.add(menuItem);

		menuItem.addActionListener(new ActionListener() {


			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				final JFrame frame = new JFrame("Preencha as informações do curso");

				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setSize(300, 280);
				frame.setVisible(true);

				//JFrame.setDefaultLookAndFeelDecorated(true);

				JLabel labelNome = new JLabel("Nome do curso");
				labelNome.setBounds(30, 30, 200, 30);
				JTextField textFieldCurso = new JTextField();
				//set size of the text box
				textFieldCurso.setBounds(30, 60, 150, 30);
				//add elements to the frame
				frame.add(labelNome);
				frame.add(textFieldCurso);

				JLabel labelCodigo = new JLabel("Código do curso");
				labelCodigo.setBounds(30, 90, 150, 30);
				JTextField textFieldCodigo = new JTextField();
				//set size of the text box
				textFieldCodigo.setBounds(30, 120, 150, 30);
				//add elements to the frame
				frame.add(labelCodigo);
				frame.add(textFieldCodigo);

				JLabel labelHorarios = new JLabel("Horários do curso (HH:mm-HH:mm)");
				labelHorarios.setBounds(30, 150, 350, 30);
				JTextField textFieldHorario = new JTextField();
				//set size of the text box
				textFieldHorario.setBounds(30, 180, 150, 30);
				//add elements to the frame
				frame.add(labelHorarios);
				frame.add(textFieldHorario);
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
							
							curso.criarNovoCurso(codigoCurso, textFieldCodigo, textFieldCurso, textFieldHorario, formatHorarioCurso, horariosCurso, contadorCursoNovo, cursos, frame);	

						}

						

					}

				});

			}

		});

	}


}
