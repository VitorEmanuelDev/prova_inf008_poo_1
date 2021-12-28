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
		Disciplina disciplina = new Disciplina();

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

							disciplina.mostrarExALunos(cursos, alunos, textFieldCodigo);
							
						}
					}
				});
			}
		});
	}
}

