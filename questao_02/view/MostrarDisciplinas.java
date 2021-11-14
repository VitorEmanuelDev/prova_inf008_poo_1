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

public class MostrarDisciplinas {

	public void mostrarDisciplinas(JMenu menu){

		JMenuItem menuItem;

		menuItem = new JMenuItem("Mostrar disiciplinas...",
				new ImageIcon("images/newfile.png"));
		menuItem.setMnemonic(KeyEvent.VK_F);
		menu.add(menuItem);

		menuItem.addActionListener(new ActionListener() {


			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				final JFrame frame = new JFrame("Codigo");

				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setSize(420, 300);
				frame.setVisible(true);

				JFrame.setDefaultLookAndFeelDecorated(true);
				
				JLabel labelCodigoo = new JLabel("Qual o código do curso");
				labelCodigoo.setBounds(30, 150, 200, 30);
				JTextField textFieldHorario = new JTextField();
				//set size of the text box
				textFieldHorario.setBounds(30, 180, 150, 30);
				//add elements to the frame
				frame.add(labelCodigoo);
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
			}
		});

	}

}


