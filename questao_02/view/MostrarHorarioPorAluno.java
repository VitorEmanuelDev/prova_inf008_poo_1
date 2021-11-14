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

public class MostrarHorarioPorAluno {

	public void mostrarHorarioPorAluno(JMenu menu){
		
		JMenuItem menuItem; 
		
		menuItem = new JMenuItem("Horários por aluno...",
				new ImageIcon("images/newproject.png"));
		menuItem.setMnemonic(KeyEvent.VK_P);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"New Project");
		menu.add(menuItem);

		menuItem.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				final JFrame frame = new JFrame("Horário por aluno");

				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setSize(310, 280);
				frame.setVisible(true);

				JFrame.setDefaultLookAndFeelDecorated(true);
				
				JLabel labelCPFAluno = new JLabel("Informe o CPF do aluno");
				labelCPFAluno.setBounds(30, 30, 200, 30);
				JTextField textCPFAluno = new JTextField();
				//set size of the text box
				textCPFAluno.setBounds(30, 60, 150, 30);
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

			}
		});

	}

}
