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
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Aluno;
import model.Curso;
import model.Disciplina;
import model.Horario;

public class LancarNota extends Menu{


	public void lancarNota(JMenu menu, ArrayList<Curso> cursos, ArrayList<Aluno> alunos, HashSet<String> cPF, HashSet<String> codigoCurso, HashSet<String> codigoDisciplina, ArrayList<Disciplina> disciplinasRealizadas){

		JMenuItem menuItem; 
		Curso curso = new Curso();

		menuItem = new JMenuItem("Lançar notas...",
				new ImageIcon("images/newfile.png"));
		menuItem.setMnemonic(KeyEvent.VK_F);
		menu.add(menuItem);


		menuItem.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				final JFrame frame = new JFrame("Lançamento de notas");

				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setSize(310, 350);
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

				JLabel labelCodigoDisciplina = new JLabel("Informe o código da disciplina");
				labelCodigoDisciplina.setBounds(30, 90, 250, 30);
				JTextField textCodigoDisciplina = new JTextField();
				//set size of the text box
				textCodigoDisciplina.setBounds(30, 120, 150, 30);
				//add elements to the frame
				frame.add(labelCodigoDisciplina);
				frame.add(textCodigoDisciplina);

				JLabel labelCPF = new JLabel("Informe o CPF do aluno");
				labelCPF.setBounds(30, 150, 200, 30);
				JTextField textCPF = new JTextField();
				//set size of the text box
				textCPF.setBounds(30, 180, 150, 30);
				//add elements to the frame
				frame.add(labelCPF);
				frame.add(textCPF);

				JLabel labelNota = new JLabel("Informe a nota obtida");
				labelNota.setBounds(30, 210, 200, 30);
				JTextField textNota = new JTextField();
				//set size of the text box
				textNota.setBounds(30, 240, 150, 30);
				//add elements to the frame
				frame.add(labelNota);
				frame.add(textNota);

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

							curso.cadastrarNota(cursos, disciplinasRealizadas, textCodigoCurso, textCodigoDisciplina, textCPF, textNota, frame);

						}

						JOptionPane.showMessageDialog(frame, "Cadastro realizado!");

					}

				});

			}
		});
	}

}
