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


import model.Aula;
import model.Curso;
import model.Disciplina;
import model.Docente;
import model.Horario;

public class NovaDisciplina extends Menu{


	//private JMenu menu;

	public void novaDisciplina(JMenu menu, ArrayList<Curso> cursos, HashSet<String> CPF, HashSet<String> codigoCurso, HashSet<String> codigoDisciplina, ArrayList<Disciplina> disciplinas, ArrayList<Horario> horariosDisciplina, ArrayList<String> datas){

		JMenuBar menuBar;
		JMenuItem menuItem;

		menuItem = new JMenuItem("Nova disciplina...",
				new ImageIcon("images/newfile.png"));
		menuItem.setMnemonic(KeyEvent.VK_F);
		menu.add(menuItem);

		menuItem.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				final JFrame frame = new JFrame("Informe os dados da disciplina");

				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setSize(350, 700);
				frame.setVisible(true);

				//JFrame.setDefaultLookAndFeelDecorated(true);

				JLabel labelNome = new JLabel("Nome da disciplina");
				labelNome.setBounds(30, 30, 250, 30);
				JTextField textFieldNome = new JTextField();
				//set size of the text box
				textFieldNome.setBounds(30, 60, 150, 30);
				//add elements to the frame
				frame.add(labelNome);
				frame.add(textFieldNome);

				JLabel labelCodigo = new JLabel("Código da disciplina");
				labelCodigo.setBounds(30, 90, 250, 30);
				JTextField textFieldCodigoDisciplina = new JTextField();
				//set size of the text box
				textFieldCodigoDisciplina.setBounds(30, 120, 150, 30);
				//add elements to the frame
				frame.add(labelCodigo);
				frame.add(textFieldCodigoDisciplina);

				JLabel labelSigla = new JLabel("Sigla da disciplina");
				labelSigla.setBounds(30, 150, 250, 30);
				JTextField textFieldSigla = new JTextField();
				//set size of the text box
				textFieldSigla.setBounds(30, 180, 150, 30);
				//add elements to the frame
				frame.add(labelSigla);
				frame.add(textFieldSigla);

				JLabel labelDocente = new JLabel("Docente");
				labelDocente.setBounds(30, 210, 250, 30);
				JTextField textFieldNomeDocente = new JTextField();
				//set size of the text box
				textFieldNomeDocente.setBounds(30, 240, 150, 30);
				//add elements to the frame
				frame.add(labelDocente);
				frame.add(textFieldNomeDocente);

				JLabel labelCPFDocente = new JLabel("CPF dp docente");
				labelCPFDocente.setBounds(30, 270, 250, 30);
				JTextField textFieldCPFDocente = new JTextField();
				//set size of the text box
				textFieldCPFDocente.setBounds(30, 300, 150, 30);
				//add elements to the frame
				frame.add(labelCPFDocente);
				frame.add(textFieldCPFDocente);

				JLabel labelHorasDisciplina = new JLabel("Qual a hora/aula da primeira data?");
				labelHorasDisciplina.setBounds(30, 330, 300, 30);
				JTextField textFieldHorasDisciplina = new JTextField();
				//set size of the text box
				textFieldHorasDisciplina.setBounds(30, 360, 150, 30);
				//add elements to the frame
				frame.add(labelHorasDisciplina);
				frame.add(textFieldHorasDisciplina);

				JLabel labelHorarioDisciplina= new JLabel("Informe o horário da disciplina HH:mm");
				labelHorarioDisciplina.setBounds(30, 390, 300, 30);
				JTextField textFieldHorarioDisciplina = new JTextField();
				//set size of the text box
				textFieldHorarioDisciplina.setBounds(30, 420, 150, 30);
				//add elements to the frame
				frame.add(labelHorarioDisciplina);
				frame.add(textFieldHorarioDisciplina);

				JLabel labelCodigoCurso = new JLabel("Informe o código do curso");
				labelCodigoCurso.setBounds(30, 450, 250, 30);
				JTextField textFieldCodigoCurso = new JTextField();
				//set size of the text box
				textFieldCodigoCurso.setBounds(30, 480, 150, 30);
				//add elements to the frame
				frame.add(labelCodigoCurso);
				frame.add(textFieldCodigoCurso);

				JLabel labelData= new JLabel("Qual a data da primeira aula? (dd-MM-yyyy)");
				labelData.setBounds(30, 510, 350, 30);
				JTextField textFieldData = new JTextField();
				//set size of the text box
				textFieldData.setBounds(30, 540, 150, 30);
				//add elements to the frame
				frame.add(labelData);
				frame.add(textFieldData);


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
							
							Disciplina disciplina = new Disciplina();
							
							disciplina.criarNovaDisciplina(codigoCurso, codigoDisciplina, cursos, CPF, disciplinas, horariosDisciplina, contadorDataNova,textFieldHorasDisciplina, textFieldData, textFieldCodigoCurso, textFieldHorarioDisciplina, textFieldCodigoDisciplina, textFieldSigla,textFieldNomeDocente, textFieldCPFDocente, textFieldNome,formatHorarioDisciplina, formatDataDisciplina, contadorDisciplinaNova, frame);	

					}


				}

			});

		}



	});

}



}
