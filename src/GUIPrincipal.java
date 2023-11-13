import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GUIPrincipal extends JFrame {

	private JPanel contentPane;
	public static int Mesa = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIPrincipal frame = new GUIPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUIPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 266, 456);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNumeroMesa = new JLabel(String.valueOf(Mesa));
		lblNumeroMesa.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroMesa.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNumeroMesa.setBounds(79, 236, 89, 57);
		contentPane.add(lblNumeroMesa);
		

		
		JButton btnAñadiralaMesa = new JButton("A\u00F1adir a la Mesa");
		btnAñadiralaMesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lblNumeroMesa.getText() == "")
					JOptionPane.showMessageDialog(null, "Por favor seleccione una mesa");
					else {
					TableroAlimentos window = new TableroAlimentos();
					window.setVisible(true);
					setVisible(false);
				}
			}
		});
		btnAñadiralaMesa.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAñadiralaMesa.setBounds(10, 317, 231, 40);
		contentPane.add(btnAñadiralaMesa);
		
		JButton button = new JButton("New button");
		button.setBounds(151, 368, -2, -1);
		contentPane.add(button);
		
		JButton btnCobrarMesa = new JButton("Cobrar a la Mesa");
		btnCobrarMesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CobrarALaMesa window = new CobrarALaMesa();
				window.setVisible(true);
				setVisible(false);
			}
		});
		btnCobrarMesa.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCobrarMesa.setBounds(10, 368, 231, 40);
		contentPane.add(btnCobrarMesa);
		

		
		JLabel lblMesaLabel = new JLabel("Mesa Actual");
		lblMesaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesaLabel.setBounds(84, 221, 76, 14);
		contentPane.add(lblMesaLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("imagenes/cafemontejo.jpg"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 11, 230, 200);
		contentPane.add(btnNewButton);
		
		JButton btnAnterior = new JButton("");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Mesa anterior = Mesas.Anterior();
				//lblNumeroMesa.setText(String.valueOf(anterior.getMesa()));
				if (Mesa == 1)
					JOptionPane.showMessageDialog(null,"No hay Mesas anteriores");
				else
				Mesa = Mesa-1;
				lblNumeroMesa.setText(String.valueOf(Mesa));
			}
		});
		btnAnterior.setIcon(new ImageIcon("imagenes/Flecha Izquierda.png"));
		btnAnterior.setBounds(10, 246, 40, 40);
		contentPane.add(btnAnterior);
		
		JButton btnSiguiente = new JButton("");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Mesa siguiente = Mesas.Siguiente();
				//lblNumeroMesa.setText(String.valueOf(siguiente.getMesa()));
				if (Mesa == 15)
					JOptionPane.showMessageDialog(null,"No hay Mesas siguientes");
				else
				Mesa = Mesa+1;
				lblNumeroMesa.setText(String.valueOf(Mesa));
			}
		});
		btnSiguiente.setIcon(new ImageIcon("imagenes/Flecha Derecha.png"));
		btnSiguiente.setBounds(201, 246, 40, 40);
		contentPane.add(btnSiguiente);
	}
}
