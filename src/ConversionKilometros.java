import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

class Interfaz extends JFrame {
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	Conversiones cv = new Conversiones();

	JTextField txtKil, txtFMillas, txtFPies, txtFPulg;
	JRadioButton rbMill, rbPies, rbPulg;
	JCheckBox chkTodos;

	JButton btnConfirmar;
	byte contP;

	public Interfaz() {
		getContentPane().setLayout(gbl);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Conversion kilometros");
		setVisible(true);
		contP = 0;
		
		// APARTADO INGRESAR KILOMETROS
		JLabel txtIngK = new JLabel("Ingresa kilometros");
		agregarComponentes(txtIngK, 0, 0, 1, 1);
		txtKil = new JTextField("0");
		txtKil.setPreferredSize(new Dimension(75,18));
		txtKil.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				String txt = txtKil.getText();

				if (e.getKeyChar() == '.') {
					if (contP == 0) {
						contP++;
					} else {
						e.consume();
					}
				} else if (e.getKeyChar() < '0' || e.getKeyChar() > '9') {
					e.consume();
				} else if (txt.equals("0") || txt.isEmpty()) {
					contP = 0;
					txtKil.setText("");
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				String txt = txtKil.getText();

				if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					if (txt.isEmpty()) {
					} else if (txt.charAt(txt.length() - 1) == '.') {
						contP = 0;
					}
				}

			}
		});//TERMINO KEY LISTENER's
		agregarComponentes(txtKil, 0, 1, 1, 1);

		// CHECKBOX "TODOS"
		JLabel txtTodos = new JLabel("<<<TODOS>>");
		agregarComponentes(txtTodos, 2, 4, 1, 1);
		chkTodos = new JCheckBox();
		chkTodos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (chkTodos.isSelected()) {
					rbMill.setEnabled(false);
					rbPies.setEnabled(false);
					rbPulg.setEnabled(false);
				} else {
					rbMill.setEnabled(true);
					rbPies.setEnabled(true);
					rbPulg.setEnabled(true);
				}

			}
		});
		agregarComponentes(chkTodos, 1, 4, 1, 1);

		// BOTON CONFIRMACION
		btnConfirmar = new JButton("Convertir");
		btnConfirmar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (chkTodos.isSelected()) {
					txtFMillas.setText(cv.kilometrosM(Double.parseDouble(txtKil.getText())));
					txtFPies.setText(cv.kilometrosP(Double.parseDouble(txtKil.getText())));
					txtFPulg.setText(cv.kilometrosPg(Double.parseDouble(txtKil.getText())));
				} else if (rbMill.isSelected()) {
					txtFMillas.setText(cv.kilometrosM(Double.parseDouble(txtKil.getText())));
				} else if (rbPies.isSelected()) {
					txtFPies.setText(cv.kilometrosP(Double.parseDouble(txtKil.getText())));
				} else if (rbPulg.isSelected()) {
					txtFPulg.setText(cv.kilometrosPg(Double.parseDouble(txtKil.getText())));
				}

			}
		});//TERMINO ACTION LISTENER
		agregarComponentes(btnConfirmar, 0, 4, 1, 1);

		// MILLAS
		rbMill = new JRadioButton();
		agregarComponentes(rbMill, 1, 0, 1, 1);
		JLabel txtMillas = new JLabel("Millas");
		agregarComponentes(txtMillas, 2, 0, 1, 1);
		txtFMillas = new JTextField();
		txtFMillas.setPreferredSize(new Dimension(100,18));
		agregarComponentes(txtFMillas, 3, 0, 1, 1);

		// PIES
		rbPies = new JRadioButton();
		agregarComponentes(rbPies, 1, 1, 1, 1);
		JLabel txtPies = new JLabel("Pies");
		agregarComponentes(txtPies, 2, 1, 1, 1);
		txtFPies = new JTextField();
		txtFPies.setPreferredSize(new Dimension(100,18));
		agregarComponentes(txtFPies, 3, 1, 1, 1);

		// PULGADAS
		rbPulg = new JRadioButton();
		agregarComponentes(rbPulg, 1, 2, 1, 1);
		JLabel txtPulg = new JLabel("Pulgadas");
		agregarComponentes(txtPulg, 2, 2, 1, 1);
		txtFPulg = new JTextField();
		txtFPulg.setPreferredSize(new Dimension(100,18));
		agregarComponentes(txtFPulg, 3, 2, 1, 1);

		ButtonGroup rdGrupo = new ButtonGroup();
		rdGrupo.add(rbMill);
		rdGrupo.add(rbPies);
		rdGrupo.add(rbPulg);

		pack();
		setLocationRelativeTo(null);
	}

	public void agregarComponentes(JComponent c, int x, int y, int altura, int anchura) {
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
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Interfaz();
			}
		});

	}

}
