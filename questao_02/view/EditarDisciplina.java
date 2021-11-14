package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class EditarDisciplina {

	public void alterarDisciplina(JMenu menu) {
		
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
				JTextField textFieldCurso = new JTextField();
				//set size of the text box
				textFieldCurso.setBounds(30, 60, 150, 30);
				//add elements to the frame
				frame.add(labelNome);
				frame.add(textFieldCurso);
				
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

				JFrame.setDefaultLookAndFeelDecorated(true);

				JLabel labelNome = new JLabel("Qual a nova carga horária? > 30 ou < 90");
				labelNome.setBounds(30, 30, 400, 30);
				JTextField textFieldCurso = new JTextField();
				//set size of the text box
				textFieldCurso.setBounds(30, 60, 150, 30);
				//add elements to the frame
				frame.add(labelNome);
				frame.add(textFieldCurso);
				
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

				JLabel labelNome = new JLabel("Qual horário deseja modificar? HH:mm");
				labelNome.setBounds(30, 30, 400, 30);
				JTextField textFieldCurso = new JTextField();
				//set size of the text box
				textFieldCurso.setBounds(30, 60, 150, 30);
				//add elements to the frame
				frame.add(labelNome);
				frame.add(textFieldCurso);
				
				JLabel labelHorario = new JLabel("Qual o novo horário? HH:mm");
				labelHorario.setBounds(30, 90, 400, 30);
				JTextField textFieldHorario = new JTextField();
				//set size of the text box
				textFieldHorario.setBounds(30, 120, 150, 30);
				//add elements to the frame
				frame.add(labelHorario);
				frame.add(textFieldHorario);
				
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

				JLabel labelNome = new JLabel("Qual data deseja modificar? HH:mm");
				labelNome.setBounds(30, 30, 400, 30);
				JTextField textFieldCurso = new JTextField();
				//set size of the text box
				textFieldCurso.setBounds(30, 60, 150, 30);
				//add elements to the frame
				frame.add(labelNome);
				frame.add(textFieldCurso);
				
				JLabel labelHorario = new JLabel("Qual a nova data? HH:mm");
				labelHorario.setBounds(30, 90, 400, 30);
				JTextField textFieldHorario = new JTextField();
				//set size of the text box
				textFieldHorario.setBounds(30, 120, 150, 30);
				//add elements to the frame
				frame.add(labelHorario);
				frame.add(textFieldHorario);
				
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

				JFrame.setDefaultLookAndFeelDecorated(true);

				JLabel labelNome = new JLabel("Informe o CPF do novo docente");
				labelNome.setBounds(30, 30, 400, 30);
				JTextField textFieldCurso = new JTextField();
				//set size of the text box
				textFieldCurso.setBounds(30, 60, 150, 30);
				//add elements to the frame
				frame.add(labelNome);
				frame.add(textFieldCurso);
				
				JLabel labelHorario = new JLabel("Qual o CPF do atual docente?");
				labelHorario.setBounds(30, 90, 400, 30);
				JTextField textFieldHorario = new JTextField();
				//set size of the text box
				textFieldHorario.setBounds(30, 120, 150, 30);
				//add elements to the frame
				frame.add(labelHorario);
				frame.add(textFieldHorario);
				
				JLabel labelCodigo = new JLabel("Informe o código da disciplina:");
				labelCodigo.setBounds(30, 150, 400, 30);
				JTextField textFieldCodigo = new JTextField();
				//set size of the text box
				textFieldCodigo.setBounds(30, 180, 150, 30);
				//add elements to the frame
				frame.add(labelCodigo);
				frame.add(textFieldCodigo);
				
				JLabel labelCPF = new JLabel("Informe o nome do novo docente:");
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
			}
		});
		
	}

}
