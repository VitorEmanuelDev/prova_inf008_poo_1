package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MostrarExAlunos {


	public void mostrarExAlunos(JMenu menu){

		JMenuItem menuItem;
		
		menuItem = new JMenuItem("Ex-Alunos...",
				new ImageIcon("images/newfile.png"));
		menuItem.setMnemonic(KeyEvent.VK_F);
		menu.add(menuItem);

		menuItem.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				final JFrame frame = new JFrame("Preencha os campos abaixo");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setSize(800, 500);
				frame.setVisible(true);
			}
			});

		}

	}

