package questao_01;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Janela {
	

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		criarUI(frame);
		frame.setSize(550, 150);      
		frame.setLocationRelativeTo(null);  
		frame.setVisible(true);
		
	}

	private static void criarUI(final JFrame frame){  
		JPanel panel = new JPanel();
		LayoutManager layout = new FlowLayout();  
		panel.setLayout(layout);       

		JButton button = new JButton("Informar área");
		final JLabel label = new JLabel();
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String inputString = (String)JOptionPane.showInputDialog(
						frame,
						"Quantos metros quadrados deseja converter?", 
						"Conversor de área",            
						JOptionPane.PLAIN_MESSAGE

						);

				ConversaoDeUnidadesDeArea conv = new ConversaoDeUnidadesDeArea();

				if(inputString != null && inputString.length() > 0){
					
					float inputFloat = Float.parseFloat(inputString);

					conv.setArea(inputFloat);
					float metrosParaPes = conv.converteMetrosParaPes(conv.getArea());
					float metrosParaAcres = conv.converteMetrosParaAcres(conv.getArea());
					float metrosParaCm = conv.converteMetrosParaCm(conv.getArea());
					
					
					label.setText(inputFloat + " m² correspondem a : "
								+ metrosParaPes + " ft², a "
								+ metrosParaAcres + " ac² e a " 
								+ metrosParaCm + " cm².");
				}else {
					label.setText("Nenhuma área informada");
				}
			}
		});

		panel.add(button);
		panel.add(label);
		frame.getContentPane().add(panel, BorderLayout.CENTER);    
	}  

}