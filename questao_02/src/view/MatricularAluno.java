package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;

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

import model.Aluno;
import model.Aula;
import model.Curso;
import model.Disciplina;
import model.Docente;

public class MatricularAluno extends Menu{

	public void matricularAluno(JMenu menu, ArrayList<Curso> cursos, ArrayList<Aluno> alunos, HashSet<String> CPF,  HashSet<String> codigoCurso, ArrayList<Disciplina> disciplinasInscritas){

		JMenuBar menuBar;
		JMenu submenu;
		JMenuItem menuItem; 
		Curso curso = new Curso();

		//a submenu
		menu.addSeparator();
		submenu = new JMenu("Matricular aluno...");
		submenu.setMnemonic(KeyEvent.VK_S);

		menuItem = new JMenuItem("Em uma disciplina");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_2, ActionEvent.ALT_MASK));
		submenu.add(menuItem);

		menuItem.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				final JFrame frame = new JFrame("Matricula em disciplina");

				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setSize(250, 400);
				frame.setVisible(true);

				//JFrame.setDefaultLookAndFeelDecorated(true);

				JLabel labelCodigoDisciplina = new JLabel("Código da disciplina");
				labelCodigoDisciplina.setBounds(30, 30, 150, 30);
				JTextField textFieldCodigoDisciplina = new JTextField();
				//set size of the text box
				textFieldCodigoDisciplina.setBounds(30, 60, 150, 30);
				//add elements to the frame
				frame.add(labelCodigoDisciplina);
				frame.add(textFieldCodigoDisciplina);

				JLabel labelCodigoCurso = new JLabel("Informe o código do curso");
				labelCodigoCurso.setBounds(30, 90, 200, 30);
				JTextField textCodigoCurso = new JTextField();
				//set size of the text box
				textCodigoCurso.setBounds(30, 120, 150, 30);
				//add elements to the frame
				frame.add(labelCodigoCurso);
				frame.add(textCodigoCurso);

				JLabel labelCPFAluno = new JLabel("Informe o CPF do aluno");
				labelCPFAluno.setBounds(30, 150, 200, 30);
				JTextField textCPFAluno = new JTextField();
				//set size of the text box
				textCPFAluno.setBounds(30, 180, 150, 30);
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

						curso.matricularAlunoDisciplina(cursos, disciplinasInscritas, textCodigoCurso, textFieldCodigoDisciplina, textCPFAluno, frame);

						JOptionPane.showMessageDialog(frame, "Cadastro realizado!");


					}

				});

			}

		});





		menuItem = new JMenuItem("Em um curso");
		submenu.add(menuItem);
		menu.add(submenu);

		menuItem.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				final JFrame frame = new JFrame("Matricula em curso");

				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setSize(310, 280);
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

				JLabel labelCPFAluno = new JLabel("Informe o CPF do aluno");
				labelCPFAluno.setBounds(30, 90, 200, 30);
				JTextField textCPFAluno = new JTextField();
				//set size of the text box
				textCPFAluno.setBounds(30, 120, 150, 30);
				//add elements to the frame
				frame.add(labelCPFAluno);
				frame.add(textCPFAluno);

				JLabel labelNomeAluno = new JLabel("Informe o nome do aluno");
				labelNomeAluno.setBounds(30, 150, 200, 30);
				JTextField textNomeAluno = new JTextField();
				//set size of the text box
				textNomeAluno.setBounds(30, 180, 150, 30);
				//add elements to the frame
				frame.add(labelNomeAluno);
				frame.add(textNomeAluno);

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

						Aluno aluno = new Aluno();
						
						curso.matricularAlunoCurso(cursos, codigoCurso, CPF, alunos, aluno, textCodigoCurso, textCPFAluno, textNomeAluno, frame);

						System.out.println("Cadastro aluno realizado " + alunos.get(contadorAlunoNovo));
						contadorAlunoNovo++;

						JOptionPane.showMessageDialog(frame, "Cadastro realizado!");


					}

				});

			}
		});
	}
}
