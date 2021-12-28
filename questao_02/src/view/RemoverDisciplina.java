package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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
import model.Disciplina;

public class RemoverDisciplina {

	public void removerDisciplina(JMenu menu, HashSet<String> codigoDisciplina, ArrayList<Disciplina> disciplinas, HashSet<String> codigoCurso, ArrayList<Curso> cursos) {

		JMenuItem menuItem;
		Disciplina disciplina = new Disciplina();

		menuItem = new JMenuItem("Remover Disciplina...",
				new ImageIcon("images/newfile.png"));
		menuItem.setMnemonic(KeyEvent.VK_F);
		menu.add(menuItem);

		menuItem.addActionListener(new ActionListener() {


			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				final JFrame frame = new JFrame("Remover");

				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setSize(250, 200);
				frame.setVisible(true);

				//JFrame.setDefaultLookAndFeelDecorated(true);

				JLabel labelCodigo = new JLabel("Código da disciplina");
				labelCodigo.setBounds(30, 30, 150, 30);
				JTextField textFieldCodigo = new JTextField();
				//set size of the text box
				textFieldCodigo.setBounds(30, 60, 150, 30);
				//add elements to the frame
				frame.add(labelCodigo);
				frame.add(textFieldCodigo);

				JLabel labelCodigoCurso = new JLabel("Código do curso");
				labelCodigoCurso.setBounds(30, 90, 150, 30);
				JTextField textFieldCodigoCurso = new JTextField();
				//set size of the text box
				textFieldCodigoCurso.setBounds(30, 120, 150, 30);
				//add elements to the frame
				frame.add(labelCodigoCurso);
				frame.add(textFieldCodigoCurso);

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

							disciplina.removerDisciplina(cursos, disciplinas, textFieldCodigoCurso, textFieldCodigo);
							
						}

						JOptionPane.showMessageDialog(frame, "Remoção realizada!");

					}

				});
			}
		});



	}

}
