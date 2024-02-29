import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

class Interfaz extends JFrame{
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	
	JTextField txtKil;
	JRadioButton rbMill, rbPies, rbPulg;
	
	JButton btnConfirmar;
	
	public Interfaz() {
		getContentPane().setLayout(gbl);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Conversion kilometros");
		setVisible(true);
		
		
		pack();
		setLocationRelativeTo(null);
	}
	
	public void agregarComponentes(JComponent c, int x,int y,int altura, int anchura) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridheight = altura;
		gbc.gridwidth = anchura;
		
		gbl.setConstraints(c, gbc);
		add(c);
	}
}
public class ConversionKilometros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
